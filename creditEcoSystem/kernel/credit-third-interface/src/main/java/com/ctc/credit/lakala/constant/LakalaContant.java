package com.ctc.credit.lakala.constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class LakalaContant {
	
	private static Logger logger = Logger.getLogger(LakalaContant.class);
	
	public static String UTF_8="UTF-8";
	
	public static String LAKALA_CUSTOMERID = "";
	
	public static String LAKALA_URL = "";
	
	
	static {
		InputStream input = null;
		Properties prop = new Properties();
		input = LakalaContant.class.getClassLoader().getResourceAsStream("credit_tip.properties");
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
		
		
		LAKALA_CUSTOMERID = prop.getProperty("lakala_customID");
		LAKALA_URL = prop.getProperty("lakala_url");
		
	}
}
