package com.ztx.selenium.uitl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtil {
	private static Logger logger = Logger.getLogger(WebdriverUtil.class);

	private WebdriverUtil() {
	}

	/**
	 * 使线程休息millis毫秒
	 * 
	 * @param millis
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据BrowserType确定获取的WebDriver类型
	 * 
	 * @param browserType
	 *            BrowserType常量
	 * @return WebDriver
	 */
	public static WebDriver getWebDriver(String browserType) {

		try {
			InputStream resourceAsStream = WebdriverUtil.class.getClassLoader()
					.getResourceAsStream("webdriver-rul.properties");
			Properties properties = new Properties();
			properties.load(resourceAsStream);
			String url = properties.getProperty("url");
			WebDriver driver = null;
			DesiredCapabilities capabilities = null;
			logger.info(Thread.currentThread().getName() + "----"
					+ Thread.currentThread().getId());
			if (BrowserType.FIREFOX.equalsIgnoreCase(browserType.trim())) {
				capabilities = DesiredCapabilities.firefox();

			} else if (BrowserType.CHROME.equalsIgnoreCase(browserType.trim())) {
				capabilities = DesiredCapabilities.chrome();
			} else if ("IE".equalsIgnoreCase(browserType.trim())
					|| BrowserType.IE.equals(browserType.trim())) {
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
			} else if (BrowserType.SAFARI.equalsIgnoreCase(browserType.trim())) {
				SafariOptions options = new SafariOptions();
				options.setUseCleanSession(true);

				capabilities = DesiredCapabilities.safari();
				capabilities.setCapability(SafariOptions.CAPABILITY, options);
			} else if (BrowserType.HTMLUNIT
					.equalsIgnoreCase(browserType.trim())) {
				capabilities = DesiredCapabilities.htmlUnit();
			}
			driver = new RemoteWebDriver(new URL(url), capabilities);
			logger.info("启动：" + capabilities.getBrowserName()
					+ "  Webdriver！！！");
			return driver;
		} catch (IOException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 最大化浏览器
	 * 
	 * @param driver
	 */
	public static void maxWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**
	 * 通过xpath获取页面一个元素，并且封装成为WebElement
	 * 
	 * @param driver
	 * @param xpath
	 * @return 如果该元素不存在则返回null，否则返回该元素的WebElement对象
	 */
	@SuppressWarnings("unused")
	public static WebElement getElement(WebDriver driver, String xpath) {

		// TODO 页面的宽度
		Long pageWidth = (Long) ((JavascriptExecutor) driver)
				.executeScript("return document.body.scrollWidth");
		// 页面的高度
		Long pageHeight = (Long) ((JavascriptExecutor) driver)
				.executeScript("return document.body.scrollHeight");
		// TODO 屏幕的宽度
		Long screenWidth = (Long) ((JavascriptExecutor) driver)
				.executeScript("return screen.width");
		// 屏幕的高度
		Long screenHeight = (Long) ((JavascriptExecutor) driver)
				.executeScript("return screen.height");

		// 需要移动的次数
		long times = pageHeight % screenHeight == 0 ? pageHeight / screenHeight
				: pageHeight / screenHeight + 1;

		if (times == 0) {
			final String xpath_ = xpath;

			WebElement ele = null;
			ele = new WebDriverWait(driver, 10)
					.until(new ExpectedCondition<WebElement>() {
						@Override
						public WebElement apply(WebDriver dr) {
							return dr.findElement(By.xpath(xpath_));
						}
					});
			return ele;
		} else {

			for (int i = 0; i < times; i++) {
				final String xpath_ = xpath;
				WebElement ele = null;
				ele = new WebDriverWait(driver, 10)
						.until(new ExpectedCondition<WebElement>() {
							@Override
							public WebElement apply(WebDriver dr) {
								return dr.findElement(By.xpath(xpath_));
							}
						});
				if (ele != null) {
					return ele;
				} else {
					((JavascriptExecutor) driver).executeScript("scrollTo(0,"
							+ (screenHeight * (i + 1)) + ")");
				}

			}
		}
		return null;
	}

	/**
	 * 通过xpath获取页面一组元素，并且把所有元素封装成为WebElement放入List集合中
	 * 
	 * @param driver
	 * @param xpath
	 * @return 如果该元素不存在则返回null，否则返回所有元素的WebElement对象组成的List集合
	 */

	@SuppressWarnings("unused")
	public static List<WebElement> getElements(WebDriver driver, String xpath) {

		// TODO 页面的宽度
		Long pageWidth = (Long) ((JavascriptExecutor) driver)
				.executeScript("return document.body.scrollWidth");
		// 页面的高度
		Long pageHeight = (Long) ((JavascriptExecutor) driver)
				.executeScript("return document.body.scrollHeight");
		// TODO 屏幕的宽度
		Long screenWidth = (Long) ((JavascriptExecutor) driver)
				.executeScript("return screen.width");
		// 屏幕的高度
		Long screenHeight = (Long) ((JavascriptExecutor) driver)
				.executeScript("return screen.height");

		// 需要移动的次数
		long times = pageHeight % screenHeight == 0 ? pageHeight / screenHeight
				: pageHeight / screenHeight + 1;

		if (times == 0) {
			final String xpath_ = xpath;

			List<WebElement> ele = null;
			ele = new WebDriverWait(driver, 10)
					.until(new ExpectedCondition<List<WebElement>>() {
						@Override
						public List<WebElement> apply(WebDriver dr) {
							return dr.findElements(By.xpath(xpath_));
						}
					});
			return ele;
		} else {

			for (int i = 0; i < times; i++) {
				final String xpath_ = xpath;
				List<WebElement> ele = null;
				ele = new WebDriverWait(driver, 10)
						.until(new ExpectedCondition<List<WebElement>>() {
							@Override
							public List<WebElement> apply(WebDriver dr) {
								return dr.findElements(By.xpath(xpath_));
							}
						});
				if (ele != null) {
					return ele;
				} else {
					((JavascriptExecutor) driver).executeScript("scrollTo(0,"
							+ (screenHeight * (i + 1)) + ")");
				}

			}
		}
		return null;
	}

	/**
	 * 判断页面元素是否存在
	 * 
	 * @param driver
	 * @param xpath
	 * @return 存在返回true，否则返回false
	 */
	public static boolean isElementExist(WebDriver driver, String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	/**
	 * 判断提示框是否出现
	 * 
	 * @param driver
	 * @return 有提示框返回true，没有则返回false
	 */
	public static boolean isAlertExist(WebDriver driver) {
		try {
			driver.switchTo().alert();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 设置系统的路径
	 * 
	 * @param windowsPath
	 *            windows的路径通常有盘符；例如:C:\test
	 * @param linuxPath
	 *            Linux系统的路径；通常没有盘符；例如:/tmp
	 * @return 根据传入的系统路径判断是什么系统，返回该系统路径;如果是在windows系统下就返回windowsPath；
	 *         如果是在Linux系统下就返回linuxPath
	 */
	public static String getRootPath(String windowsPath, String linuxPath) {
		String root = null;
		String OSName = System.getProperty("os.name");
		if (OSName.toUpperCase().contains("Windows".toUpperCase())) {
			root = windowsPath;
		}
		if (OSName.toUpperCase().contains("Linux".toUpperCase())) {
			root = linuxPath;
		}
		return root;
	}

	/**
	 * 刷新浏览器
	 * 
	 * @param driver
	 */
	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * 截图工具
	 * 
	 * @param driver
	 * @param name
	 * @return 截图成功返回图片存放的路径，否则返回null
	 */
	public static String screenShot(WebDriver driver, String name) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日--HH点mm分ss秒");
		String time = sdf.format(new Date());
		File scrFile = ((TakesScreenshot) (driver))
				.getScreenshotAs(OutputType.FILE);

		/**
		 * 例如Windows下：c:\selenium\screenshot\errorIMG\${name}--${time}.jpg
		 * Linux下：/tmp/selenium/screenshot/errorIMG\${name}--${time}.jpg
		 */
		String root = getRootPath("d:\\selenium", "/selenium");
		String picName = root + File.separator + "screenshot" + File.separator
				+ name + "--" + time + ".jpg";
		System.out.println(picName);
		try {
			FileUtils.copyFile(scrFile, new File(picName));
			return picName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
