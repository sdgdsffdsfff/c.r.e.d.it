package com.ztx.credit.report.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public abstract class AbstractKeyValue {

	private Logger logger = Logger.getLogger(AbstractKeyValue.class);

	/**
	 * 把字段名称为一行且对应的值也为一行的数据数据放入map中,并且验证传入的字段
	 * 
	 * @param columnRow
	 * @param columnsToVarify
	 * @return 名称和对应的值组成的map
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	protected Map<String, String> getKeyValue(WebElement columnRow,
			String... columnsToVarify) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		try {
			// 获取当前对象的所有文本值
			String keysTxt = columnRow.getText().replaceAll("\\s", "");

			for (int i = 0; i < columnsToVarify.length; i++) {
				if (!keysTxt.contains(columnsToVarify[i])) {
					String err = "getKeyValue: 验证不通过 [" + keysTxt + "]" + "不包含"
							+ "[" + columnsToVarify[i] + "]";
					logger.info(err);
					throw new Exception(err);
				}
			}

			// 获取当前行的所有标题
			List<WebElement> keys = columnRow.findElements(By
					.xpath("./child::*"));
			// 获取当前标题行下面的一行的所有值
			List<WebElement> values = columnRow.findElements(By
					.xpath("./following::tr[1]/child::*"));

			int keysCount = keys.size();
			int valuesCount = values.size();

			if (keysCount < 1) {

				String err = "不存在的标题！！！标题个数为：" + keysCount;
				logger.info(err);
				throw new Exception(err);
			}

			if (keysCount == valuesCount) {
				for (int i = 0; i < keysCount; i++) {
					// 标题
					String key = keys.get(i).getText().replaceAll("\\s", "");
					// 标题对应的值
					String value = values.get(i).getText()
							.replaceAll("\\s", "");

					// 把标题和值存入map中
					map.put(key, value);
				}
			} else if (keysCount > valuesCount) {// 标题数量大于值的数量，也会存储部分数据，但有数据丢失的风险
				for (int i = 0; i < valuesCount; i++) {
					// 标题
					String key = keys.get(i).getText().replaceAll("\\s", "");
					// 标题对应的值
					String value = values.get(i).getText()
							.replaceAll("\\s", "");

					// 把标题和值存入map中
					map.put(key, value);
				}

				String err = "数据有丢失！！！标题数量 大于 值的数量！！";
				logger.info(err);
				throw new Exception(err);
			} else {// 标题数量小于值的数量，也会存储部分数据，但有数据丢失的风险
				for (int i = 0; i < keysCount; i++) {
					// 标题
					String key = keys.get(i).getText().replaceAll("\\s", "");
					// 标题对应的值
					String value = values.get(i).getText()
							.replaceAll("\\s", "");

					// 把标题和值存入map中
					map.put(key, value);
				}

				String err = "数据有丢失！！！标题数量 小于 值的数量！！";
				logger.info(err);
				throw new Exception(err);
			}

			if (map.size() < 1) {
				String err = "没有数据";
				logger.info(err);
				throw new Exception(err);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			return map;
		}
	}

	/**
	 * 把字段名称为两行且对应的值为一行的数据数据放入map中,并且验证传入的字段
	 * 
	 * @param columnRowBig
	 * @param columnsToVarifyBig
	 * @param columnsToVarifySmall
	 * @return
	 */
	@SuppressWarnings("finally")
	protected Map<String, String> getKeyValueSpecial(WebElement columnRowBig,
			String[] columnsToVarifyBig, String... columnsToVarifySmall) {
		Map<String, String> map = new HashMap<String, String>();

		try {
			// 获取当前大标题对象的所有文本值
			String keysTxtBig = columnRowBig.getText().replaceAll("\\s", "");

			for (int i = 0; i < columnsToVarifyBig.length; i++) {
				if (!keysTxtBig.contains(columnsToVarifyBig[i])) {

					String err = "getKeyValueSpecial: 大标题验证不通过 [" + keysTxtBig
							+ "]" + "不包含" + "[" + columnsToVarifyBig[i] + "]";
					logger.info(err);
					throw new Exception(err);
				}
			}

			// 获取当前小标题对象的所有文本值
			String keysTxtSmall = columnRowBig
					.findElement(By.xpath("./following::tr[1]")).getText()
					.replaceAll("\\s", "");

			for (int i = 0; i < columnsToVarifySmall.length; i++) {
				if (!keysTxtSmall.contains(columnsToVarifySmall[i])) {

					String err = "getKeyValueSpecial: 小标题验证不通过 ["
							+ keysTxtSmall + "]" + "不包含" + "["
							+ columnsToVarifySmall[i] + "]";
					logger.info(err);
					throw new Exception(err);
				}
			}
			// 获取当前行的所有大标题
			List<WebElement> keysBig = columnRowBig.findElements(By
					.xpath("./child::*"));
			// 获取当前行的所有小标题
			List<WebElement> keysSmall = columnRowBig.findElements(By
					.xpath("./following::tr[1]/child::*"));

			// 获取所有值
			List<WebElement> values = columnRowBig.findElements(By
					.xpath("./following::tr[2]/child::*"));

			int keysBigCount = keysBig.size();
			int keysSmallCount = keysSmall.size();

			if (keysBigCount < 1) {
				String err = "不存在的大标题！！！大标题个数为：" + keysBigCount;
				logger.info(err);
				throw new Exception(err);

			}
			if (keysSmallCount < 1) {
				String err = "不存在的小标题！！！小标题个数为：" + keysSmallCount;
				logger.info(err);
				throw new Exception(err);
			}

			if (keysTxtBig.contains("查询机构数")) {
				int count = keysSmallCount / keysBigCount;
				for (int i = 0; i < keysSmallCount; i++) {
					// 大标题
					String keyBig = keysBig.get((i == 6 ? (i - 1) : i) / count)
							.getText().replaceAll("\\s", "");
					// 小标题
					String keySmall = keysSmall.get(i).getText()
							.replaceAll("\\s", "");

					// 标题对应的值
					String value = values.get(i).getText()
							.replaceAll("\\s", "");
					// key=大标题+小标题
					map.put(keyBig + keySmall, value);

				}
			} else {

				int count = keysSmallCount / keysBigCount;
				for (int i = 0; i < keysSmallCount; i++) {
					// 大标题
					String keyBig = keysBig.get(i / count).getText()
							.replaceAll("\\s", "");
					// 小标题
					String keySmall = keysSmall.get(i).getText()
							.replaceAll("\\s", "");

					// 标题对应的值
					String value = values.get(i).getText()
							.replaceAll("\\s", "");
					// key=大标题+小标题
					map.put(keyBig + keySmall, value);

				}

			}

		} catch (Exception e) {
			logger.info(e);
			throw new Exception(e);
		} finally {
			return map;
		}
	}
	
	protected WebElement getNextElement(WebElement e){
		return e.findElement(By.xpath("./following::*[1]"));
	}
	
	protected WebElement getNextElement(WebElement searchContext,
			String stopStr[], String... columns) throws Exception {
		String tagName = searchContext.getTagName();
		for (int i = 0; i < 1000; i++) {
			String xpath = "./following::"+tagName+"[" + (i + 1) + "]";
			try {
				WebElement e = searchContext.findElement(By.xpath(xpath));

				String keysTxt = e.getText().replaceAll("\\s", "");
				boolean isExist = true;
				for (int k = 0; k < columns.length; k++) {
					if (!keysTxt.contains(columns[k])) {
						isExist = false;
					}
				}
				for (int k = 0; k < stopStr.length; k++) {
					if (keysTxt.contains(stopStr[k])) {
						logger.info("遇到中断字符串:" + stopStr[k]);
						return null;
					}
				}

				if (isExist) {

					return e;
				}
			} catch (Exception e) {
				return null;
			}
		}

		return null;

	}

	
	/**
	 * 根据参数名称找需要的元素对象
	 * 
	 * @param searchContext
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	protected WebElement getElementFixed(SearchContext searchContext,
			String... columns) throws Exception {

		for (int i = 0; i < columns.length; i++) {
			String xpath = ".//*[contains(text(),'" + columns[0] + "')]";

			for (int j = 1; j < 20; j++) {
				String newXpath = xpath + "/ancestor::*[" + j + "]";

				List<WebElement> keys = searchContext.findElements(By
						.xpath(newXpath));

				for (int index = 0; index < keys.size(); index++) {

					String keysTxt = "";
					try {
						keysTxt = keys.get(index).getText()
								.replaceAll("\\s", "");
					} catch (Exception e) {

					}
					boolean isExist = true;
					for (int k = 0; k < columns.length; k++) {
						if (!keysTxt.contains(columns[k])) {
							isExist = false;
						}
					}
					if (isExist) {
						return keys.get(index);
					}
				}

			}
		}
		logger.info("数据[" + Arrays.toString(columns) + "]没有找到！！");
		throw new Exception("数据[" + Arrays.toString(columns) + "]没有找到！！");
	}

	
	/**
	 * 根据参数名称找需要的元素对象
	 * 
	 * @param searchContext
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	protected WebElement getElement(SearchContext searchContext,
			String... columns) throws Exception {

		for (int i = 0; i < columns.length; i++) {
			String xpath = ".//*[contains(text(),'" + columns[i] + "')]";

			for (int j = 1; j < 20; j++) {
				String newXpath = xpath + "/ancestor::*[" + j + "]";

				List<WebElement> keys = searchContext.findElements(By
						.xpath(newXpath));

				for (int index = 0; index < keys.size(); index++) {

					String keysTxt = "";
					try {
						keysTxt = keys.get(index).getText()
								.replaceAll("\\s", "");
					} catch (Exception e) {

					}
					boolean isExist = true;
					for (int k = 0; k < columns.length; k++) {
						if (!keysTxt.contains(columns[k])) {
							isExist = false;
						}
					}
					if (isExist) {
						return keys.get(index);
					}
				}

			}
		}
		logger.info("数据[" + Arrays.toString(columns) + "]没有找到！！");
		throw new Exception("数据[" + Arrays.toString(columns) + "]没有找到！！");
	}

	protected List<WebElement> getElements(SearchContext searchContext,
			String stopStr[], String... columns) throws Exception {
		List<WebElement> elements = new ArrayList<WebElement>();

		WebElement e = this.getElement(searchContext, columns);
		if (e != null) {
			elements.add(e);
		} else {
			throw new Exception("没有找到数据：" + Arrays.toString(columns));
		}
		while (true) {
			WebElement nextElement = this.getNextElement(e, stopStr, columns);
			if (nextElement != null) {
				elements.add(nextElement);
				e = nextElement;
			} else {
				break;
			}
		}

		return elements;

	}

	protected List<Map<String, String>> getListData(WebElement columnRow,
			WebElement columnRow2, String columnsToVarify[],
			String... columnsToVarify2) throws Exception {
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();

		if (columnRow == null && columnRow2 == null) {
			throw new Exception("getListData：标题对象为空！");
		}

		if (columnRow == null && columnRow2 != null) {
			return this.getListData(columnRow2, columnsToVarify2);
		}
		if (columnRow != null && columnRow2 == null) {
			return this.getListData(columnRow, columnsToVarify);
		}

		// 获取当前对象的所有文本值
		String keysTxt = columnRow.getText().replaceAll("\\s", "");
		// 验证字段是否存在
		for (int i = 0; i < columnsToVarify.length; i++) {
			if (!keysTxt.contains(columnsToVarify[i])) {

				String err = "getListData: 验证不通过 [" + keysTxt + "]" + "不包含"
						+ "[" + columnsToVarify[i] + "]";
				logger.info(err);
				throw new Exception(err);

			}
		}
		// 获取当前对象的所有文本值
		String keysTxt2 = columnRow2.getText().replaceAll("\\s", "");
		// 验证字段是否存在
		for (int i = 0; i < columnsToVarify2.length; i++) {
			if (!keysTxt2.contains(columnsToVarify2[i])) {

				String err = "getListData: 验证不通过 [" + keysTxt2 + "]" + "不包含"
						+ "[" + columnsToVarify2[i] + "]";
				logger.info(err);
				throw new Exception(err);

			}
		}

		List<WebElement> keys = columnRow.findElements(By.xpath("./child::*"));
		List<WebElement> keys2 = columnRow2
				.findElements(By.xpath("./child::*"));
		int keysCount = keys.size();
		int keysCount2 = keys2.size();
		for (int i = 1; i < 24; i++) {
			List<WebElement> values = columnRow.findElements(By
					.xpath("./following::tr[" + i + "]/child::*"));
			List<WebElement> values2 = columnRow2.findElements(By
					.xpath("./following::tr[" + i + "]/child::*"));
			int valuesCount = values.size();

			if (keysCount < 1) {

				String err = "不存在的标题！！！标题个数为：" + keysCount;
				logger.info(err);
				throw new Exception(err);
			}
			int valuesCount2 = values2.size();

			if (keysCount2 < 1) {

				String err = "不存在的标题！！！标题个数为：" + keysCount2;
				logger.info(err);
				throw new Exception(err);
			}
			Map<String, String> map = new HashMap<String, String>();
			if (keysCount == valuesCount && keysCount2 == valuesCount2) {// 如果标题数目和值的数目一样，那么就存入map

				for (int j = 0; j < keysCount; j++) {
					// 标题
					String key = keys.get(j).getText().replaceAll("\\s", "");
					// 标题对应的值
					String value = values.get(j).getText()
							.replaceAll("\\s", "");

					// 把标题和值存入map中
					map.put(key, value);
				}
				for (int j = 0; j < keysCount2; j++) {
					// 标题
					String key = keys2.get(j).getText().replaceAll("\\s", "");
					// 标题对应的值
					String value = values2.get(j).getText()
							.replaceAll("\\s", "");

					// 把标题和值存入map中
					map.put(key, value);
				}

			} else {
				break;
			}

			maps.add(map);

			if (maps.size() < 1) {
				String err = "没有数据";
				logger.info(err);
				throw new Exception(err);
			}

		}

		return maps;
	}

	protected List<Map<String, String>> getListData(WebElement columnRow,
			String... columnsToVarify) throws Exception {
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();

		// 获取当前对象的所有文本值
		String keysTxt = columnRow.getText().replaceAll("\\s", "");
		// System.out.println(keysTxt);
		// 验证字段是否存在
		for (int i = 0; i < columnsToVarify.length; i++) {
			if (!keysTxt.contains(columnsToVarify[i])) {

				String err = "getListData: 验证不通过 [" + keysTxt + "]" + "不包含"
						+ "[" + columnsToVarify[i] + "]";
				logger.info(err);
				throw new Exception(err);

			}
		}
		List<WebElement> keys = columnRow.findElements(By.xpath("./child::*"));
		int keysCount = keys.size();
		for (int i = 1; i < 6; i++) {

			List<WebElement> values = columnRow.findElements(By
					.xpath("./following::tr[" + i + "]/child::*"));
			int valuesCount = values.size();

			if (keysCount < 1) {

				String err = "不存在的标题！！！标题个数为：" + keysCount;
				logger.info(err);
				throw new Exception(err);
			}

			// System.out.println(keysCount);
			// System.out.println(valuesCount);
			if (keysCount == valuesCount) {// 如果标题数目和值的数目一样，那么就存入map
				String vTxt = columnRow
						.findElement(By.xpath("./following::tr[" + i + "]"))
						.getText().replaceAll("\\s", "");
				try {
					for (int k = 0; k < columnsToVarify.length; k++) {
						if (vTxt != null && vTxt.contains(columnsToVarify[k])
								&& vTxt.startsWith("编")) {

							throw new Exception();

						}
					}
				} catch (Exception e) {
					break;
				}

				Map<String, String> map = new HashMap<String, String>();
				for (int j = 0; j < keysCount; j++) {
					// 标题
					String key = keys.get(j).getText().replaceAll("\\s", "");
					// 标题对应的值
					String value = values.get(j).getText()
							.replaceAll("\\s", "");

					// 把标题和值存入map中
					map.put(key, value);
				}
				maps.add(map);
			} else {

				break;

			}
		}
		if (maps.size() < 1) {
			String err = "没有数据";
			logger.info(err);
			throw new Exception(err);
		}
		return maps;
	}

}
