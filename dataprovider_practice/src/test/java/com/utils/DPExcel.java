package com.utils;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DPExcel {
	@DataProvider(name="invalidexcelData",parallel=true)
	public Object[][] excelDataProvider() throws IOException{
		Object[][] arrObj = invalidgetExcelData("C:\\Users\\akksh\\OneDrive\\Desktop\\Testing modules\\Java Training\\Selenium basics\\dataprovider_practice\\src\\main\\resources\\DataProvider.xlsx", "Sheet1");
		return arrObj;
	}

	private Object[][] invalidgetExcelData(String fileName, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int noofRows = sheet.getPhysicalNumberOfRows();
			int noofCols = row.getLastCellNum();
			Cell cell;
			data = new String[noofRows - 1][noofCols];
			for(int i = 1;i<noofRows;i++) {
				for(int j = 0;j<noofCols;j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);
					data[i-1][j] = cell.toString();
				}
			}
		}
		catch(Exception e){
			throw new RuntimeException("The Exception is : " + e.getMessage());
		}
		return data;
	}
	@DataProvider(name="validexcelData",parallel=true)
	public Object[][] validexcelDataProvider() throws IOException{
		Object[][] arrObj = getExcelData1("C:\\Users\\akksh\\OneDrive\\Desktop\\Testing modules\\Java Training\\Selenium basics\\dataprovider_practice\\src\\main\\resources\\DataProvider.xlsx", "Sheet1");
		return arrObj;
	}

	private Object[][] getExcelData1(String fileName, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int noofRows = sheet.getPhysicalNumberOfRows();
			int noofCols = row.getLastCellNum();
			Cell cell;
			data = new String[noofRows - 1][noofCols];
			row = sheet.getRow(0);
			cell = row.getCell(0);
			data[0][0] = cell.toString();
		}
		catch(Exception e){
			throw new RuntimeException("The Exception is : " + e.getMessage());
		}
		return data;
	}

}
