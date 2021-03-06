package com.goibibo.qa.utilties;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetTestData {
	
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public GetTestData(String path){
		
		
		try
		{
		    file = new FileInputStream(path);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			
			file.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public Object[][] getCellData(String sheetName) {
		
		int i=0, j=0;
		String celldata = " ";
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		row = sheet.getRow(0);
		int colcount = row.getLastCellNum();
		Object data[][] = new Object[rowcount][colcount];
		row = sheet.getRow(0);
		
		for(i=1; i<=rowcount; i++)
		{
			row = sheet.getRow(i);
			for(j=0; j<colcount; j++)
			{
				celldata = row.getCell(j).getStringCellValue();
				//System.out.println(celldata);
				data[i-1][j] = celldata;
			}

		}
		
		return data;
	}
	
	public static void main(String[] args) {
		GetTestData getTestData = new GetTestData("C:\\Project\\TestAutomation\\src\\main\\java\\com\\goibibo\\qa\\testData\\testData.xlsx");
		getTestData.workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	}

}
