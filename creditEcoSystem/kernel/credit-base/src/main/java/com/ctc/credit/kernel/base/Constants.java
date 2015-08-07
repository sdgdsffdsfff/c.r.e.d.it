package com.ctc.credit.kernel.base;

import org.springframework.context.ApplicationContext;

/**
 * Constant values used throughout the application.
 * 
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class Constants {
	// ~ Static fields/initializers

	/**
	 * The name of the ResourceBundle used in this application
	 */
	public static final String BUNDLE_KEY = "ApplicationResources";

	/**
	 * File separator from System properties
	 */
	public static final String FILE_SEP = System.getProperty("file.separator");

	/**
	 * User home from System properties
	 */
	public static final String USER_HOME = System.getProperty("user.home")
			+ FILE_SEP;

	public static final int QUERY_PAGE_MAX_SIZE = 65000;

	public static final String CONFIG = "appConfig";

	public static String RESOURCE_PATH = "";  //资源路径
	
	public static String BASE_PATH = "";

	public static final String PATH_SEPARATOR = "/";

	public static ApplicationContext ctx = null;

	public static String exportPath;
	
	public static String OUT_ACCTID;
	public static Integer OUT_ACCOUNT_ID;
	public static String OUT_CUSTID;
	public static Integer OUT_USERID;
	public static String CONTRACT_PATH = Constants.PATH_SEPARATOR + "resource"  + Constants.PATH_SEPARATOR + "contract";
}
