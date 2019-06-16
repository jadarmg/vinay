package com.excel.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel
{
     public static String getExcelValues() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
     {
    	 String v="";
    	    Workbook w = WorkbookFactory.create(new FileInputStream(""));
    	 	Sheet sheet1 = w.getSheet("");
    	 	int rowval=sheet1.getLastRowNum();	
			v=w.getSheet("").getRow(1).getCell(1).toString();
			for(int rowcount=1;rowval<=rowval-1;rowval++)
			{
			String a1 = ReadExcel.getExcelValues();
			System.out.println(a1);	
			}	
			return v;
}
     
     public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
     {
    	 ReadExcel.getExcelValues();
     }
}
	