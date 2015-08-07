package com.ctc.credit.shenzhourong.api.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ctc.credit.qianhai.constant.QianHaiEnum;
import com.ctc.credit.shenzhourong.api.dto.SzrRequestDto;
import com.ctc.credit.shenzhourong.api.dto.SzrBlkListResponseDto;
import com.ctc.credit.shenzhourong.api.dto.SzrCPointResponseDto;
import com.ctc.credit.shenzhourong.api.service.SzrCreditApiService;
import com.ctc.credit.shenzhourong.util.Base64Util;
import com.ctc.credit.shenzhourong.util.ICreditInfoExtWebservice;
import com.ctc.credit.shenzhourong.util.RSAUtil;

@org.springframework.stereotype.Service
public class SzrCreditApiServiceImpl implements SzrCreditApiService {
	private static Logger logger = Logger.getLogger(SzrCreditApiServiceImpl.class);
	
	
	public static void main(String[] args) {
		SzrRequestDto dto = new SzrRequestDto();
		dto.setUserId("lisi");
		dto.setPassword("lisi");
		dto.setIdNo("371525199011030310");//371525199011030310  320106198107173214
		dto.setName("安威");//安威 安吉
		dto.setIdType("0");
		SzrCreditApiServiceImpl test = new SzrCreditApiServiceImpl();
		SzrBlkListResponseDto rdto = test.getSzrBlkListresult(dto);
		String json = JSONObject.fromObject(rdto).toString();
		System.out.println(json);
		System.out.println("NICE");
	}
	
	
	@SuppressWarnings("finally")
	@Override
	public SzrBlkListResponseDto getSzrBlkListresult(SzrRequestDto requestDto){
		logger.info("----------------ShenZhouRong BLKLIST Remote Request Begin------------------------");
		long start = System.currentTimeMillis();
		URL url = null;
		String requestParameter = null;
		Document doc = null;
		SzrBlkListResponseDto responseDto = new SzrBlkListResponseDto();
		try {
			url = new URL("http://www.rongsz.cn:8081/internetfinance/webservice/creditInfoExt?wsdl");
			String userId = "lisi";
			String password = "lisi";
			Map<String,String> parameter = new HashMap<String,String>();
			parameter.put("SERVICECODE", requestDto.getServiceCode());
			parameter.put("ID", requestDto.getIdNo());
			parameter.put("NAME", requestDto.getName());
			parameter.put("IDTYPE", requestDto.getIdType());
			logger.info("-----请求参数：parameter：" + parameter);
			requestParameter = generateRequestParameterXML(userId, password, parameter);
			QName qname = new QName("http://webservice.internetfinance.com/", "creditInfoExtWebservice");
			Service service = Service.create(url, qname);
			ICreditInfoExtWebservice webservice = service.getPort(ICreditInfoExtWebservice.class);
			String result = webservice.queryServiceItemByCode(requestParameter);
			logger.info("返回结果: "+ result);
			doc = DocumentHelper.parseText(result);
			//获取根节点
//			Element root = doc.getRootElement();
//			String status = root.element("MESSAGE").element("STATUS").getText();
			String status = doc.selectSingleNode("/DATA/MESSAGE/STATUS").getText();
			String value = doc.selectSingleNode("/DATA/MESSAGE/VALUE").getText();
			responseDto.setStatus(status);
			responseDto.setValue(value);
			if(status.equals("0")){/*查询成功解密XML*/
				if(!value.equals("记录为空")){
					String resultsElement = doc.selectSingleNode("/DATA/RESULTS").getText();
					byte[] btRsa = RSAUtil.decryptByPrivateKey(Base64Util.base64ToByteArray(resultsElement), getPrivateKey());
					String realResults = new String(btRsa, "utf-8");
					doc = DocumentHelper.parseText(realResults);
					getDtoFromXml(responseDto, doc);
					logger.info("查询成功");
					logger.info("解密XML：" + realResults);
				}
			}else {
				logger.info("查询失败，错误代码：" + status + ",对应原因：" +  value);
			}
			logger.info("ShenZhouRong Remote Service Time：" + (System.currentTimeMillis() - start));
			logger.info("----------------ShenZhouRong BLKLIST Remote Request End------------------------");	
		} catch (MalformedURLException e1) {
			logger.error("http post throw ConnectTimeoutException", e1);
			throw new RuntimeException(QianHaiEnum.EXC_CODE_A0000+"||ConnectTimeoutException",e1);
		} catch (InvalidKeyException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (InvalidKeySpecException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (IllegalBlockSizeException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (BadPaddingException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (IOException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (DocumentException e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			return responseDto;
		}
	}
	
	@SuppressWarnings("finally")
	@Override
	public SzrCPointResponseDto getSzrCreditPointResult(SzrRequestDto requestDto) {
		logger.info("----------------ShenZhouRong BLKLIST Remote Request Begin------------------------");
		long start = System.currentTimeMillis();
		URL url = null;
		String requestParameter = null;
		Document doc = null;
		SzrCPointResponseDto responseDto = new SzrCPointResponseDto();
		try {
			url = new URL("http://www.rongsz.cn:8081/internetfinance/webservice/creditInfoExt?wsdl");
			String userId = "lisi";
			String password = "lisi";
			Map<String,String> parameter = new HashMap<String,String>();
			parameter.put("SERVICECODE", requestDto.getServiceCode());
			parameter.put("IDNO", requestDto.getIdNo());
			parameter.put("NAME", requestDto.getName());
			parameter.put("MOBILE", requestDto.getMobile());
			logger.info("-----请求参数：parameter：" + parameter);
			requestParameter = generateRequestParameterXML(userId, password, parameter);
			QName qname = new QName("http://webservice.internetfinance.com/", "creditInfoExtWebservice");
			Service service = Service.create(url, qname);
			ICreditInfoExtWebservice webservice = service.getPort(ICreditInfoExtWebservice.class);
			String result = webservice.queryServiceItemByCode(requestParameter);
			logger.info("返回结果: "+ result);
			doc = DocumentHelper.parseText(result);
			//获取根节点
//			Element root = doc.getRootElement();
//			String status = root.element("MESSAGE").element("STATUS").getText();
			String status = doc.selectSingleNode("/DATA/MESSAGE/STATUS").getText();
			String value = doc.selectSingleNode("/DATA/MESSAGE/VALUE").getText();
			responseDto.setStatus(status);
			responseDto.setValue(value);
			if(status.equals("0")){/*查询成功解密XML*/
				if(!value.equals("记录为空")){
					String resultsElement = doc.selectSingleNode("/DATA/RESULTS").getText();
					byte[] btRsa = RSAUtil.decryptByPrivateKey(Base64Util.base64ToByteArray(resultsElement), getPrivateKey());
					String realResults = new String(btRsa, "utf-8");
					doc = DocumentHelper.parseText(realResults);
					getDtoFromXml(responseDto, doc);
					logger.info("查询成功");
					logger.info("解密XML：" + realResults);
				}
			}else {
				logger.info("查询失败，错误代码：" + status + ",对应原因：" +  value);
			}
			logger.info("ShenZhouRong Remote Service Time：" + (System.currentTimeMillis() - start));
			logger.info("----------------ShenZhouRong BLKLIST Remote Request End------------------------");	
		} catch (MalformedURLException e1) {
			logger.error("http post throw ConnectTimeoutException", e1);
			throw new RuntimeException(QianHaiEnum.EXC_CODE_A0000+"||ConnectTimeoutException",e1);
		} catch (InvalidKeyException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (InvalidKeySpecException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (IllegalBlockSizeException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (BadPaddingException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (IOException e1) {
			logger.info(e1);
			e1.printStackTrace();
		} catch (DocumentException e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			return responseDto;
		}
	}
	
	/**
	 * 信用评分接口转换xml
	 * @author Chengang
	 * @param dto
	 * @param doc
	 * @return
	 */
	private SzrCPointResponseDto getDtoFromXml(SzrCPointResponseDto dto, Document doc){
		dto.setMobile(doc.selectSingleNode("/RESULT/MOBILLE").getText());
		dto.setScore(doc.selectSingleNode("/RESULT/SCORE").getText());
		dto.setTag1(doc.selectSingleNode("/RESULT/TAG1").getText());
		dto.setTag2(doc.selectSingleNode("/RESULT/TAG2").getText());
		dto.setTag3(doc.selectSingleNode("/RESULT/TAG3").getText());
		return dto;
	}
	
	/**
	 * 黑名单接口转换xml
	 * @author Chengang
	 * @param dto
	 * @param doc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private SzrBlkListResponseDto getDtoFromXml(SzrBlkListResponseDto dto, Document doc){
//		dto.setIdNo(doc.selectSingleNode("/RESULT/IDNO").getText());
//		dto.setIdType(doc.selectSingleNode("/RESULT/IDTYPE").getText());
//		dto.setName(doc.selectSingleNode("/RESULT/NAME").getText());
//		dto.setGrade(doc.selectSingleNode("/RESULT/GRADE").getText());
//		dto.setSourceId(doc.selectSingleNode("/RESULT/SOURCEID").getText());
		Element root = doc.getRootElement();
		List<Element> elements = root.elements();
		for (Element el : elements) {
			String name = el.getName();
			String value = el.getText();
			if(value != null){
				switch (name) {
					case "IDNO":
						dto.setIdNo(value);
						break;
					case "IDTYPE":
						dto.setIdType(value);
						break;
					case "NAME":
						dto.setName(value);
						break;
					case "GRADE":
						dto.setGrade(value);
						break;
					case "SOURCEID":
						dto.setSourceId(value);
						break;
					default:
						break;
				}
			}
		}
		return dto;
	}
	
	/**
	 * 将请求参数转换成XML
	 * @param loginName
	 * @param password
	 * @param parameter
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	private static String generateRequestParameterXML(String userId,String password,Map<String,String> parameter) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException{
		Document doc = DocumentHelper.createDocument();
		doc.setXMLEncoding("UTF-8");
		Element root = doc.addElement("ROOT");
		Element metaData = root.addElement("METADATA");
		metaData.addElement("USERID").setText(userId);
		metaData.addElement("PASSWORD").setText(encryptByPrivateKey(password, getPrivateKey()));
		Element batches = root.addElement("BATCHES");
		Element batch = batches.addElement("BATCH");
		
		Set<Entry<String, String>> set = parameter.entrySet();
		for(Entry<String, String> entry:set){
			batch.addElement(entry.getKey()).setText(encryptByPrivateKey(entry.getValue(), getPrivateKey()));
		}
		return doc.asXML();
	}
	
	/**
	 * 对源数据并返回加密数据
	 * @param encodeText
	 * @param privateKey
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	private static String encryptByPrivateKey(String encodeText,String privateKey) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException{
		byte[] encodeData = RSAUtil.encryptByPrivateKey(encodeText.getBytes("UTF-8"), privateKey);
		return Base64Util.byteArrayToBase64(encodeData);
	}
	
	/**
	 * 获取私钥
	 * @return
	 */
	private static String getPrivateKey(){
        return "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANI9Lva/AlC68AC/XT+BHbmN8JI0iVJAKyONaoZSsumghtApvPA9mDMH7ant"
			+ "LQLvTsjSvny0cAsQr6ayqfSUqTGpAzfRj+do6bj9LMFcly1XPTfXzP2yZsEZURkFEWSJJc3VFYMUa9RGmoDfGxgFdQX7qeEj387g5ejJ0IzlWi1tAgMBAAE"
			+ "CgYEAgCARcwbNXm3OvmXhakZB20eJiVDDL4EzySLx/JKBvqe6ATqujqq7Cr6WNKz6dYNqPDFTLaS5c8Tjh2/y6799rE7XEc5sFDZ8hbzO0sE5CK0bz8XU4Hd"
			+ "p1+nqy/VgAoKoV3eL45LlERuG7cwTCHcBgURCr6HKIusOKidqyTWhdYECQQD19+ooIiClynxR8Scwq2OEQZQvI+i1+jGedZ5lamSazUTpS7eQfVijGS+E0YiQ"
			+ "cowdLQBw08DTcEUR6WjfxLuVAkEA2tA6bGWu9AkVfBsR4JIrd6FIobviyLjdZY9fPZxv+smwe14lDXpQqjJRNIrOik13f8EGg1klK7tKnVXeg2Z0eQJBALNNO"
			+ "9ZxulbhGmspXiYuaecZXwpWJOezMMSQfRz0x83I4PkoBvI/TYPncipiDCkwN091ZKLa2e/IIbGC8r5cTVkCQBDCunbrIweWWorzF9930tSLCiE5Xxm471yEKut"
			+ "xPDKdmGMaxwPNRriCui2oJEH7xReIFZOiFHLRGdoLZcvy4SECQQCkJg6Zua0KP+MnW14VeKiaCoSIX6TzJkN0QJGt0nJNUG3gdz7pQPGH5is7ZsVv/5/dbKVF55mU3JwTm0+OQnkd";
	}

}
