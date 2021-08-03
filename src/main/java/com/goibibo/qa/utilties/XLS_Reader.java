package com.goibibo.qa.utilties;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLS_Reader {
	
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public XLS_Reader(String path){
		
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
	
	public void getRowCount(String sheetName) {
		
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
	}
	

}
