package com.qa.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	static String projectPath = System.getProperty("user.dir");
	static String filePath = projectPath + "/src/test/excel/";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public excel(String excelPath, String sheetName) throws IOException{
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}
	
	public int getRowCount() throws IOException{
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row Count: " + rowCount);
		return rowCount;
	}
	
	public String getCellDataString(int rowNum, int colNum) throws IOException{
		
		String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(data);
		return data;
	}
	public  double getCellDataNumber(int rowNum, int colNum) throws IOException{
		double data = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(data);
		return data;
	}

	public int getColCount() {
		// TODO Auto-generated method stub
		int colCount = 0;
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Col Count: " + colCount);
		return colCount;
	}
}
