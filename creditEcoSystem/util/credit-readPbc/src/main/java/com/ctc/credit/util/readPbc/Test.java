package com.ctc.credit.util.readPbc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ctc.credit.util.readPbc.service.ApPbcInfoService;
import com.ctc.credit.util.readPbc.util.MessyCode;

public class Test {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
	    /**
	     * 
	     * 
	     * select count(1) from ap_pbc_info

--SELECT LOCATION_ FROM BDF_UPLOAD_INFO WHERE ID_ = 'eb0f9431-5f77-430f-b1b9-c3dd5bdbeb9a'

--SELECT * FROM BDF_BLOB_STORE where ID_ = '5945b6ba-7693-46e2-b12c-1a7fbd287d9b'
	     */
//	    ApplicationContext  context = 
//	    new   ClassPathXmlApplicationContext("applicationContext-resources.xml","applicationContext-product.xml");    
//	    ApPbcInfoService    ap =  (ApPbcInfoService)context.getBean("apPbcInfoServiceImpl");  
//	    Blob blob = ap.getApPbcInfo();
//	    InputStream msgContent =(InputStream) blob.getBinaryStream();
//	    byte[] byte_data = new byte[(int)blob.length()];
//	    msgContent.read(byte_data);
//	    String result = new String(byte_data,"UTF-8");
//	    Boolean isMessy = MessyCode.isMessyCode(result);
//	    System.out.println(isMessy);
//	    if(isMessy){
//	    	result = new String(byte_data,"GB2312");
//	    }
//	    
//	    
//	    FileWriter fileWritter = new FileWriter("C:/Users/daniel/test.html",true);
//        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
//        bufferWritter.write(result);
//        bufferWritter.close();
        
	}

}
