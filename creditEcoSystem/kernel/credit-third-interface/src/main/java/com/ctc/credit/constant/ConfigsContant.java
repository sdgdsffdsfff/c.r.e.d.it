package com.ctc.credit.constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ConfigsContant {
	
	// test
	
	private static Logger logger = Logger.getLogger(ConfigsContant.class);
	
	/** 消金反欺诈批量回调Hessian接口地址  **/
	public static  String CONSUM_LOAN_REQ_URL="";
	
	/** 小贷  **/
	public static final String SOURCE_SYS_SMALOAN="01";
	
	/** 车贷  **/
	public static final String SOURCE_SYS_CARLOAN="02";
	
	/** 消金  **/
	public static final String SOURCE_SYS_CONSUMLOAN="03";
	
	public static String UTF_8="UTF-8";
	
	public static String DEFAULT_USER="zxadmin";
	
	/** xls 保存目录 **/
	public static String XLS_SAVE_PATH = "";
	
	/** xls 临时文件目录 **/
	public static String XLS_TMP_PATH = "";
	
	/** 前海keystore **/
	public static String QIANHAI_KEYSTORE_PATH = "";
	
	/** 前海keystore pwd **/
	public static String QIANHAI_KEYSTORE_PWD = "";
	
	/** 前海keystore **/
	public static String QIANHAI_TRUST_KEYSTORE_PATH = "";
	
	/** 前海keystore pwd **/
	public static String QIANHAI_TRUST_KEYSTORE_PWD = "";
	
	/** 前海主机 **/
	public static String QIANHAI_REQUEST_URL = "";
	
	/** 前海用户名 **/
	public static String QIANHAI_USER_NAME = "";
	
	/** 前海pwd **/
	public static String QIANHAI_USER_PWD = "";
	
	/** 前海 请求数据签名 signkey **/
	public static String QIANHAI_SIGN_KEY_PATH = "";
	
	/** 前海 请求数据 3DES key **/
	public static String QIANHAI_3DES_KEY = "";
	
	/** 前海keystore 证书别名 **/
	public static String QIANHAI_KEYSTORE_ALIA = "";
	
	
	static {
		InputStream input = null;
		Properties prop = new Properties();
		input = ConfigsContant.class.getClassLoader().getResourceAsStream("credit_file.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			logger.equals(e.getMessage());
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				input = null;
				e.printStackTrace();
			}
		}
		try {
			File file = new File(prop.getProperty("conf_file"));
			input = new FileInputStream(file);
			prop.load(input);
		} catch (IOException e) {
			logger.equals(e.getMessage());
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				input = null;
				e.printStackTrace();
			}
		}
		XLS_SAVE_PATH = prop.getProperty("xls_save_path");
		XLS_TMP_PATH = prop.getProperty("xls_tmp_path");
		QIANHAI_KEYSTORE_PATH = prop.getProperty("qianhai_keystore");
		QIANHAI_KEYSTORE_PWD = prop.getProperty("qianhai_keystore_pwd");
		QIANHAI_TRUST_KEYSTORE_PATH = prop.getProperty("qianhai_trust_keystore");
		QIANHAI_TRUST_KEYSTORE_PWD = prop.getProperty("qianhai_trust_keystore_pwd");
		QIANHAI_REQUEST_URL = prop.getProperty("qianhai_request_url");
		QIANHAI_USER_NAME = prop.getProperty("qianhai_user_name");
		QIANHAI_USER_PWD = prop.getProperty("qianhai_user_pwd");
		QIANHAI_SIGN_KEY_PATH = prop.getProperty("qianhai_signkey_path");
		QIANHAI_3DES_KEY = prop.getProperty("qianhai_3des_key");
		QIANHAI_KEYSTORE_ALIA = prop.getProperty("qianhai_keystore_alia");
		CONSUM_LOAN_REQ_URL = prop.getProperty("consum_loan_req_url");
		
		logger.info("xls_save_path:"+XLS_SAVE_PATH);
		logger.info("xls_tmp_path:"+XLS_TMP_PATH);
		logger.info("qianhai_keystore:"+QIANHAI_KEYSTORE_PATH);
		logger.info("qianhai_keystore_pwd:"+QIANHAI_KEYSTORE_PWD);
		logger.info("qianhai_trust_keystore:"+QIANHAI_TRUST_KEYSTORE_PATH);
		logger.info("qianhai_trust_keystore_pwd:"+QIANHAI_TRUST_KEYSTORE_PWD);
		logger.info("qianhai_request_url:"+QIANHAI_REQUEST_URL);
		logger.info("qianhai_user_name:"+QIANHAI_USER_NAME);
		logger.info("qianhai_user_pwd:"+QIANHAI_USER_PWD);
		logger.info("qianhai_signkey_path:"+QIANHAI_SIGN_KEY_PATH);
		logger.info("qianhai_3des_key:"+QIANHAI_3DES_KEY);
		logger.info("qianhai_keystore_alia:"+QIANHAI_KEYSTORE_ALIA);
	}
}
