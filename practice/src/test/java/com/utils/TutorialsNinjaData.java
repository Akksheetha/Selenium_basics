package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TutorialsNinjaData {
	@DataProvider(name="tutorialsninjadata", parallel = true)
	public Object[][] excelDataProvider() throws IOException{
		Object[][] arrObj = getExcelData("C:\\Users\\akksh\\OneDrive\\Desktop\\Testing modules\\Java Training\\Selenium basics\\dataprovider_practice\\src\\main\\resources\\DataProvider.xlsx", "Sheet2");
		return arrObj;
	}

	private Object[][] getExcelData(String fileName, String sheetName) throws IOException {
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
			workbook.close();
		}
		catch(Exception e){
			throw new RuntimeException("The Exception is : " + e.getMessage());
		}
		return data;
	}
	@DataProvider(name = "searchData")
	public Object[][] searchproduct() throws Exception{
		Object[][] arrObj = getSearchData("C:\\Users\\akksh\\OneDrive\\Desktop\\Testing modules\\Java Training\\Selenium basics\\dataprovider_practice\\src\\main\\resources\\DataProvider.xlsx", "Sheet3");
		return arrObj;
	}
	public Object[][] getSearchData(String fileName, String sheetName) throws Exception {

		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int noofRows = sheet.getPhysicalNumberOfRows();
			Cell cell;
			data = new String[noofRows - 1][1];
			for(int i = 1;i<noofRows;i++) {
					row = sheet.getRow(i);
					cell = row.getCell(0);
					data[i-1][0] = cell.toString();
			}
			workbook.close();
		}
		catch(Exception e){
			throw new RuntimeException("The Exception is : " + e.getMessage());
		}
		return data;
	}
}
