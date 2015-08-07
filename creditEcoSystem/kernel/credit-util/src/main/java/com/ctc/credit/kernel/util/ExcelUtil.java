package com.ctc.credit.kernel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static final String EXCEL_XLS = "XLS";
	public static final String EXCEL_xls = "xls";
	public static final String EXCEL_XLSX = "XLSX";
	public static final String EXCEL_xlsx = "xlsx";
   
    /**  
     * 读取xls文件内容  
     *  
     * @return List<XlsDto>对象  
     * @throws IOException  
     *             输入/输出(i/o)异常  
     */
    private static void readXls(String filePath) throws IOException {  
        InputStream is = new FileInputStream(filePath);  
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);  
        // 循环工作表Sheet  
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {  
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
            if (hssfSheet == null) {  
                continue;  
            }  
            // 循环行Row  
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);  
                if (hssfRow == null) {  
                    continue;  
                }  
                // 循环列Cell  
                // 0学号 1姓名 2学院 3课程名 4 成绩  
                // for (int cellNum = 0; cellNum <=4; cellNum++) {  
                HSSFCell xh = hssfRow.getCell(0);  
                if (xh == null) {  
                    continue;  
                }  
                HSSFCell xm = hssfRow.getCell(1);  
                if (xm == null) {  
                    continue;  
                }  
                HSSFCell yxsmc = hssfRow.getCell(2);  
                if (yxsmc == null) {  
                    continue;  
                }  
                HSSFCell kcm = hssfRow.getCell(3);  
                if (kcm == null) {  
                    continue;  
                }  
                HSSFCell cj = hssfRow.getCell(4);  
                if (cj == null) {  
                    continue;  
                }  
            }  
        }  
    }  
    
    private static void readXlsx(String filePath) throws IOException {  
        InputStream is = new FileInputStream(filePath);  
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);  
        // 循环工作表Sheet  
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {  
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
            if (hssfSheet == null) {  
                continue;  
            }  
            // 循环行Row  
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);  
                if (hssfRow == null) {  
                    continue;  
                }
//                for (XSSFCell cell : hssfRow.get) {
//                	 if (cell == null) {  
//                         continue;  
//                     }  
//				}
                // 循环列Cell  
                // 0学号 1姓名 2学院 3课程名 4 成绩  
                // for (int cellNum = 0; cellNum <=4; cellNum++) {  
                XSSFCell xh = hssfRow.getCell(0);  
                if (xh == null) {  
                    continue;  
                }  
                XSSFCell xm = hssfRow.getCell(1);  
                if (xm == null) {  
                    continue;  
                }  
                XSSFCell yxsmc = hssfRow.getCell(2);  
                if (yxsmc == null) {  
                    continue;  
                }  
                XSSFCell kcm = hssfRow.getCell(3);  
                if (kcm == null) {  
                    continue;  
                }  
                XSSFCell cj = hssfRow.getCell(4);  
                if (cj == null) {  
                    continue;  
                }  
            }  
        }  
    }

    /**
     * 读取xlsx流
     * @param inputStream
     * @throws IOException
     */
	public static List<?> readXlsFile(InputStream inputStream,String fileName) throws IOException{
		//文件后缀格式  
        String fileEnd = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
        List<List<String>> rowData = new ArrayList<List<String>>();
        if(EXCEL_XLSX.equals(fileEnd)||EXCEL_xlsx.equals(fileEnd)){
        	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);  
            XSSFSheet xssfSheet =  xssfWorkbook.getSheetAt(0); //默认取第一个sheet
            // 循环行Row  
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {  
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if(null!=xssfRow){
                	List<String> colData = new ArrayList<String>();
                	for (int i = 0; i < 36; i++) {
                     	XSSFCell cell = xssfRow.getCell(i);
                     	String val = getValue(cell);
                 		colData.add(val==null?"":val);
     				}
                	rowData.add(colData);
                }
            }
        }else if(EXCEL_XLS.endsWith(fileEnd)||EXCEL_xls.endsWith(fileEnd)){
        	HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);  
            HSSFSheet hssfSheet =  hssfWorkbook.getSheetAt(0); //默认取第一个sheet
            // 循环行Row  
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if(null!=hssfRow){
                	List<String> colData = new ArrayList<String>();
                	for (int i = 0; i < 36; i++) {
                     	HSSFCell cell = hssfRow.getCell(i);
                     	String val = getValue(cell);
                 		colData.add(val==null?"":val);
     				}
                	rowData.add(colData);
                }
            }
        }
		return rowData;  
    }
    
    private static String getValue(Cell cell) {  
    	if(null == cell){
    		return "";
    	}
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {  
            // 返回布尔类型的值  
            return String.valueOf(cell.getBooleanCellValue());  
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {  
            // 返回数值类型的值  
        	 DecimalFormat format = new DecimalFormat("#");
    		 String saf = format.format(cell.getNumericCellValue());
            return saf;  
        } else {  
            // 返回字符串类型的值  
            return String.valueOf(cell.getStringCellValue());  
        }  
    }
    
	public static void main(String[] args) throws IOException { 
		String filePath ="C:\\Users\\SUNNY\\Desktop\\黑灰名单导入模板.xlsx";
		readXlsx(filePath);
    } 
}