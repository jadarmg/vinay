package com.excel.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Optimized 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
		
	
	public static String main(String[] args) 
	{
	      String readExcel(String path,String Sheet, int row, int column)
	{
		String v="";
		Workbook w = WorkbookFactory.create(new FileInputStream(path));
		org.apache.poi.ss.usermodel.Sheet a = w.getSheet(Sheet);
		int roucount=a.ge
		v=w.getSheet(Sheet).getRow(row).getCell(column).toString();
		for(int rowval=1;rowval<=roucount-1;rowval++)
		{
			String a1 = ReadExcel.getExcelValues("./workbook/workbook.xlsx","Test",0,rowval);
			System.out.println(a1);
		}
	
	}
	}

}
