package com.ctc.credit.util.readPbc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.net.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.util.readPbc.service.ApPbcInfoService;
import com.ctc.credit.util.readPbc.util.FileFilterUtil;
import com.ctc.credit.util.readPbc.util.MessyCode;



@Controller
public class ReadPbcController {

	@Autowired
	private ApPbcInfoService apPbcInfoService;
	@Autowired
	private JmsTemplate jmsTempalte;
	
	@ResponseBody
	@RequestMapping(produces="text/html;charset=UTF-8",value="/getPbc.action",method=RequestMethod.GET) 
	public String getPbc(@RequestParam String id) throws SQLException, IOException{
		Blob blob = apPbcInfoService.getApPbcInfo(id);
	    InputStream msgContent =(InputStream) blob.getBinaryStream();
	    byte[] byte_data = new byte[(int)blob.length()];
	    msgContent.read(byte_data);
	    String result = new String(byte_data,"UTF-8");
	    Boolean isMessy = MessyCode.isMessyCode(result);
	    if(isMessy){
	    	result = new String(byte_data,"GB2312");
	    }
	    
		return  result;
	}
	
	
	
	@ResponseBody
	@RequestMapping(produces="text/html;charset=UTF-8",value="/getPbcFromFile.action",method=RequestMethod.GET) 
	public String getPbcFromFile(@RequestParam String fileName) throws SQLException, IOException{
//		String fileNameUrlD = URLDecoder.decode(fileName);
//		byte[] filePath = Base64.decodeBase64(fileNameUrlD);
//		String reportName = new String(filePath,"UTF-8");
		System.out.print(fileName);
		File file = new File(fileName);
		InputStream is = new FileInputStream(file);
		byte[] byte_data = new byte[(int)file.length()];
		is.read(byte_data);
		is.close();
		String result =  new String(byte_data,"UTF-8");
		return  result;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/initPbcReport.action",method=RequestMethod.GET) 
	public String initPbcReport() throws SQLException, IOException{
//		while(true){
			List<String> fileId = apPbcInfoService.getNeedAnalysisFiles();
//			if(fileId.size() == 0){
//				break;
//			}
			for(final String id: fileId){
				jmsTempalte.send(new MessageCreator() {  
			        public Message createMessage(Session session) throws JMSException {  
			            return session.createTextMessage(id);  
			        }  
			    }); 
			}
//		}
		
		return "finish";
	}
	
	@ResponseBody
	@RequestMapping(value="/initPbcReportByFile.action",method=RequestMethod.GET) 
	public String initPbcReportByFile(@RequestParam String docPath) throws SQLException, IOException{
	    List<File>  files  = getFiles("C:/Users/daniel/Desktop/存量报告_待处理_HTML");	
		for(final File id: files){
			jmsTempalte.send(new MessageCreator() {  
		        public Message createMessage(Session session) throws JMSException {  
		            return session.createTextMessage(id.getPath());  
		        }  
		    }); 
		}
		return "finish";
	}
	
	
	public List<File> getFiles(String path){
	    File root = new File(path);
	    List<File> files = new ArrayList<File>();
	    if(!root.isDirectory()){
	        files.add(root);
	    }else{
	        File[] subFiles = root.listFiles(new FileFilterUtil());
	        for(File f : subFiles){
	            files.addAll(getFiles(f.getAbsolutePath()));
	        }    
	    }
	    return files;
	}
}
