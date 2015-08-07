package com.ctc.credit.blackgreylist.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ctc.credit.blackgreylist.annotation.XlsWrite;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.model.XlsCheckReturnEntity;
import com.ctc.credit.blackgreylist.service.CreditBlkgraylistDetailEntityService;
import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.kernel.util.DateUtil;
import com.ctc.credit.kernel.util.ExcelUtil;

@Controller
@RequestMapping(value = "/service/blackgraylist")
public class XlsFileuploadController {
	
	private static Logger logger = Logger.getLogger(XlsFileuploadController.class);
	
	/** 文件上传最大大小**/
	private static Long FILE_MAX_UPLOAD_SIZE = (long) (5*1024*1024);
	
	/** 允许上传文件类型 **/
	private static String[] FILE_ALLOW = {"xls","xlsx"};
	
	@Autowired
	CreditBlkgraylistDetailEntityService creditBlkgraylistDetailEntityService;
	
	@RequestMapping(value = "/xlsfileupload.action", method = RequestMethod.POST)
	public void xlsFileupload(HttpServletRequest request,HttpServletResponse response){
		XlsCheckReturnEntity xlsCheckReturnEntity = new XlsCheckReturnEntity();
		xlsCheckReturnEntity.setResultMsg(XlsCheckReturnEntity.RES_SUCCESS);
		FileItem fileItem = getFileItem(request);
		Boolean fileSaveFlg = true;
		Boolean fileCheckFlg = true;
		String reMsg = "";
		if (!checkCategoryAndSize(fileItem,xlsCheckReturnEntity)){
			fileCheckFlg = false;
			fileSaveFlg = false;
		}
		if (fileCheckFlg&&checkXlsFormation(fileItem, xlsCheckReturnEntity)) {
			try {
				saveXlsData(fileItem,xlsCheckReturnEntity);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				xlsCheckReturnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
				xlsCheckReturnEntity.setErrorMsg(XlsCheckReturnEntity.RES_DEFEAT_SAVE_ERR);
				fileSaveFlg = false;
			}
		}
		if (fileSaveFlg)
			saveXlsFile(fileItem,xlsCheckReturnEntity);
		reMsg = genReturnHtml(xlsCheckReturnEntity);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		writer.write(reMsg);
	}
	
	/**
	 * 返回客户端的提示信息
	 * 
	 * @param xlsCheckReturnEntity
	 * @return
	 */
	private String genReturnHtml(XlsCheckReturnEntity xlsCheckReturnEntity){
		StringBuilder sBuilder = new StringBuilder();
		if(xlsCheckReturnEntity.getResultMsg().equals(XlsCheckReturnEntity.RES_SUCCESS)){
			sBuilder.append("上传状态："+XlsCheckReturnEntity.RES_SUCCESS_STR+"<br/>");
			sBuilder.append("概要信息：共上传成功"+xlsCheckReturnEntity.getSuccessDataCount()+"条数据！");
		}else {
			sBuilder.append("上传状态："+XlsCheckReturnEntity.RES_DEFEAT_STR+"<br/>");
			sBuilder.append("错误信息："+xlsCheckReturnEntity.getErrorMsg());
		}
		return sBuilder.toString();
		
	}
	
	private void saveXlsFile(FileItem fileItem,XlsCheckReturnEntity xlsCheckReturnEntity){
	    String resultMsg = xlsCheckReturnEntity.getResultMsg();
		String fileSavePath = ConfigsContant.XLS_SAVE_PATH;
		File fileSave = new File(fileSavePath);
		if(!fileSave.exists()){
			fileSave.mkdirs();
		}
	  if(StringUtils.isNotEmpty(resultMsg)&&resultMsg.equals(XlsCheckReturnEntity.RES_SUCCESS)){
		  try {
			  String uuid = UUID.randomUUID().toString();  
              //真实上传路径  
              StringBuffer sbRealPath = new StringBuffer();  
              String fileName = fileItem.getName();
              String fileEnd = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();  
              sbRealPath.append(fileSavePath).append(uuid).append(".").append(fileEnd);  
              //写入文件  
              File file = new File(sbRealPath.toString());
              fileItem.write(file);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	  }
	}
	
	/**
	 * 获取上传文件对象
	 * 
	 * @param request
	 * @return
	 */
	private FileItem getFileItem(HttpServletRequest request){
		String fileSavePath = ConfigsContant.XLS_SAVE_PATH;
		String fileTmpPath = ConfigsContant.XLS_TMP_PATH;
		File fileSave = new File(fileSavePath);
		File fileTmp = new File(fileTmpPath);
		if(!fileSave.exists()){
			fileSave.mkdirs();
		}
		if(!fileTmp.exists()){
			fileTmp.mkdirs();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();  
        factory.setRepository(fileTmp);  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {
            //获取所有文件列表  
            List<FileItem> items = upload.parseRequest(request);
        	 for (FileItem item : items) {
                 if(!item.isFormField()){
                	 return item;
                 }
             }
		} catch (Exception e) {
			logger.error(e.getMessage());
		}  
		return null;
	}

	/**
	 * 检查文件类型和大小
	 * 
	 * @param item
	 * @return
	 */
	private Boolean checkCategoryAndSize(FileItem item,
			XlsCheckReturnEntity xlsCheckReturnEntity) {
		if(null == item){
			xlsCheckReturnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
			xlsCheckReturnEntity.setErrorMsg("上传文件为空！");
			return false;
		}
		//文件大小
		Long fileSize = item.getSize();
		// 文件名
		String fileName = item.getName();
		// 检查文件后缀格式
		String fileEnd = fileName.substring(fileName.lastIndexOf(".") + 1)
				.toLowerCase();
		if (fileSize==0) {
			xlsCheckReturnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
			xlsCheckReturnEntity.setErrorMsg("上传文件为空！");
			return false;
		}
//		if(fileSize>FILE_MAX_UPLOAD_SIZE){
//			xlsCheckReturnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
//			xlsCheckReturnEntity.setErrorMsg("上传文件大小超过限制5M！");
//			return false;
//		}
		if(!checkTag(fileEnd)){
			xlsCheckReturnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
			xlsCheckReturnEntity.setErrorMsg("上传文件类型非法，只能上传xls和xlsx类型文件!");
			return false;
		}
		return true;
	}

	/**
	 * 检查后缀名是否合法
	 * @param endName
	 * @return
	 */
	private Boolean checkTag(String endName){
		if(null==endName)
			return false;
		for (int i = 0; i < FILE_ALLOW.length; i++) {
			String tag = FILE_ALLOW[i];
			if(endName.equals(tag))
				return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private Boolean checkXlsFormation(FileItem fileItem,XlsCheckReturnEntity returnEntity){
		InputStream is = null;
		try {
			is = fileItem.getInputStream();
		} catch (IOException e1) {
			logger.error(e1.getMessage());
		}
		List<List<String>> rowData = new ArrayList<List<String>>();
		try {
			rowData = (List<List<String>>) ExcelUtil.readXlsFile(is,fileItem.getName());
			rowDataList = rowData;
		} catch (IOException e) {
			logger.error("读取Excel 数据失败，"+e.getMessage());
		}
		if(rowData.size()==0){
			returnEntity.setErrorMsg(XlsCheckReturnEntity.RES_DEFEAT);
			returnEntity.setResultMsg("上传文件为空");
		}else if (rowData.size()>0) {
			StringBuilder sbAll = new StringBuilder();
			Boolean errorFlag = false;
			for (int rowNum = 0; rowNum < rowData.size(); rowNum++) {
				StringBuilder sbRow = new StringBuilder();
				if(rowNum<2)
					continue;
				if(checkIfEmptyRow(rowData.get(rowNum)))
					continue;
				String category = rowData.get(rowNum).get(0);
				String name = rowData.get(rowNum).get(1);
				String idCard = rowData.get(rowNum).get(2);
				String mobile = rowData.get(rowNum).get(3);
				String province = rowData.get(rowNum).get(4);
				String city = rowData.get(rowNum).get(6);
				String distinct = rowData.get(rowNum).get(7);
				String homePhone = rowData.get(rowNum).get(8);
				String corpName = rowData.get(rowNum).get(9);
				String corpPhone = rowData.get(rowNum).get(10);
				String corpAddress = rowData.get(rowNum).get(11);
				String memo = rowData.get(rowNum).get(12);
				String applyNo = rowData.get(rowNum).get(13);
				String saler = rowData.get(rowNum).get(14);
				String salerDepart = rowData.get(rowNum).get(15);
				StringBuilder sb = new StringBuilder();
				if (StringUtils.isEmpty(category)) {
					errorFlag = true;
					returnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
					sb.append("类别名称未填写|");
				}else{
					if(null == CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY.get(category)){
						errorFlag = true;
						returnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
						sb.append("类别名称不在指定的类别内|");
					}
				}
				if (StringUtils.isEmpty(name)&&
						StringUtils.isEmpty(idCard)&&
						StringUtils.isEmpty(mobile)&&
						StringUtils.isEmpty(province)&&
						StringUtils.isEmpty(city)&&
						StringUtils.isEmpty(distinct)&&
						StringUtils.isEmpty(homePhone)&&
						StringUtils.isEmpty(corpName)&&
						StringUtils.isEmpty(corpPhone)&&
						StringUtils.isEmpty(corpAddress)&&
						StringUtils.isEmpty(memo)&&
						StringUtils.isEmpty(applyNo)&&
						StringUtils.isEmpty(saler)&&
						StringUtils.isEmpty(salerDepart)) {
					errorFlag = true;
					returnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
					sb.append("客户信息项和销售信息项必填一项|");
				}
				if (errorFlag) {
					sbRow.append("第"+(rowNum+1)+"行,信息有误，");
					sbRow.append(sb.append("<br/>"));
					sbAll.append("<br/>"+sbRow.toString());
				}
			}
			if (errorFlag) {
				returnEntity.setErrorMsg(sbAll.toString());
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查是否为空行
	 * @param row
	 * @return
	 */
	private Boolean checkIfEmptyRow(List<String> row){
		if(null!=row)
			for (String st : row)
				if(StringUtils.isNotEmpty(st))
					return false;
		return true;
	}
	
	private XlsCheckReturnEntity saveXlsData(FileItem fileItem,XlsCheckReturnEntity returnEntity){
		returnEntity.setResultMsg(XlsCheckReturnEntity.RES_SUCCESS);
		List<List<String>> rowData = new ArrayList<List<String>>();
		rowData =rowDataList;
		if(rowData.size()==0){
			returnEntity.setResultMsg(XlsCheckReturnEntity.RES_DEFEAT);
			returnEntity.setErrorMsg("上传文件为空");
		}else if (rowData.size()>0) {
			List<CreditBlkgraylistDetailEntity> blkDetails = new ArrayList<CreditBlkgraylistDetailEntity>();
			for (int rowNum = 0; rowNum < rowData.size(); rowNum++) {
				CreditBlkgraylistDetailEntity blkDetail = new CreditBlkgraylistDetailEntity();
				if(rowNum<2)
					continue;
				if(checkIfEmptyRow(rowData.get(rowNum)))
					continue;
				for (int colNum = 0; colNum < rowData.get(rowNum).size(); colNum++) {
					String val = rowData.get(rowNum).get(colNum);
					Method method = getWriteCols(colNum);
					try {
						method.invoke(blkDetail, val.trim());
					} catch (IllegalAccessException e) {
						logger.error(e.getMessage());
					} catch (IllegalArgumentException e) {
						logger.error(e.getMessage());
					} catch (InvocationTargetException e) {
						logger.error(e.getMessage());
					}
				}
				blkDetails.add(blkDetail);
			}
			returnEntity.setSuccessDataCount(blkDetails.size());
			for (CreditBlkgraylistDetailEntity creditBlkgraylistDetailEntity : blkDetails) {
				creditBlkgraylistDetailEntity.setEnable(new Long(0));
				creditBlkgraylistDetailEntity.setCreateUser("zxadmin");
				creditBlkgraylistDetailEntity.setChannel(0l);
				creditBlkgraylistDetailEntity.setSourceSys(0l);
				creditBlkgraylistDetailEntity.setCreateDate(DateUtil.getFormatDateByyyyyMMddHHmmssFile(new Date()));
				String desc = creditBlkgraylistDetailEntity.getCategoryDesc();
				if (StringUtils.isNotEmpty(desc)) {
					String category = CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY.get(desc);
					if (StringUtils.isNotEmpty(category)) {
						creditBlkgraylistDetailEntity.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY.get(desc));
						if (category.endsWith("blacklist")){
							creditBlkgraylistDetailEntity.setWarnLevel(new Long(0));
						}
						else if(category.endsWith("graylist")){
							creditBlkgraylistDetailEntity.setWarnLevel(new Long(1));
						}
					}
				}
			}
			
			creditBlkgraylistDetailEntityService.saveAndCreateIndexs(blkDetails);
			
		}
		return returnEntity;
	}
	
	/**
	 * 获取要写入字段
	 * @return
	 */
	private Method getWriteCols(int colIndex){
		Class<CreditBlkgraylistDetailEntity> clazz = CreditBlkgraylistDetailEntity.class;
		if(fieldstoUse.size()==0){
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				XlsWrite xlsWrite = field
						.getAnnotation(XlsWrite.class);
				if (null != xlsWrite)
					fieldstoUse.add(field);
			}
			Collections.sort(fieldstoUse, new Comparator<Field>() {
				@Override
				public int compare(Field o1, Field o2) {
					if (null != o1 && null != o2) {
						XlsWrite xlsWrite1 = o1
								.getAnnotation(XlsWrite.class);
						XlsWrite xlsWrite2 = o2
								.getAnnotation(XlsWrite.class);
						if (null != xlsWrite1
								&& null != xlsWrite2)
							return new Integer(xlsWrite1.order())
									.compareTo(new Integer(xlsWrite2
											.order()));
					}
					return 0;
				}
			});
		}
		Field field = fieldstoUse.get(colIndex);
		String fielName = field.getName();
		Method entitySetMethod = null;
		try {
			entitySetMethod = clazz.getMethod("set"
					+ fielName.substring(0, 1).toUpperCase()
					+ fielName.substring(1),String.class);
		} catch (NoSuchMethodException e) {
			logger.error(e.getMessage());
		} catch (SecurityException e) {
			logger.error(e.getMessage());
		}
		entitySetMethod.setAccessible(true);
		return entitySetMethod;
	}
	
	public static List<Field> fieldstoUse = new ArrayList<Field>();
	
	private static List<List<String>> rowDataList = null;
}
