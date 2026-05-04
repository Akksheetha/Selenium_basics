package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	
	@DataProvider(name="DataForSignUp")
	public Object[][] excelDataProvider() throws IOException{
		Object[][] arrObj = getData("C:\\Users\\akksh\\OneDrive\\Desktop\\Testing modules\\Java Training\\Selenium basics\\dataprovider_practice\\src\\main\\resources\\DataProvider.xlsx", "Sheet1");
		return arrObj;
	}

    public static Object[][] getData(String path, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }

            wb.close();
            return data;

        } catch (Exception e) {
            return null;
        }
    }
}