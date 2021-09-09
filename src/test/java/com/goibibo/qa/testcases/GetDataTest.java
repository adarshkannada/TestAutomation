package com.goibibo.qa.testcases;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.goibibo.qa.utilties.XLS_Reader;

public class GetDataTest {

	 XLS_Reader xlreader;  
	 
	 @Test
	 public void GetDataFromExcel()
	 {
		 Object data[][] = null;
//		 xlreader = new XLS_Reader("/home/freedom/Documents/eclipse/TestAutomation/src/main/java/com/goibibo/qa/testData/testData.xlsx");
		 
		 if(System.getProperty("os.name").equals("Linux")){
			xlreader = new XLS_Reader("/home/freedom/Documents/eclipse/TestAutomation/src/main/java/com/goibibo/qa/testData/testData.xlsx");
		}
		else if(System.getProperty("os.name").equals("Windows 10")){
				xlreader = new XLS_Reader("C:\\Project\\TestAutomation\\src\\main\\java\\com\\goibibo\\qa\\testData\\testData.xlsx");
			}
		 
		 
		 data =  xlreader.getCellData("Sheet1");
		 for(int i =1;i<=2;i++)
		 {
			 for(int j=0;j<2;j++)
			 {
				 System.out.println(data[i-1][j]);
			 }
		 }
	 }
}
