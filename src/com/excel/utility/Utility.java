package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utility 
{
	public static String getPhoto(WebDriver driver,String folder)
	{
		//Taking a screen shot which will be called in after method in listners class
		Date d=new Date();
		//System.out.println(d.toString());
		String dateTime=d.toString().replaceAll(":","_");
		//System.out.println(dateTime);
		String path=folder+"/"+dateTime+".png";
		//System.out.println(path);
		
		try {
				TakesScreenshot t=(TakesScreenshot)driver;
				File srcFile = t.getScreenshotAs(OutputType.FILE);
				File destFile=new File(path);
				FileUtils.copyFile(srcFile, destFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	public static WebDriver openBrowser(String ip,String browser)
	{
		
	//Selenium Grid concept will come here if not it will pen browser in default browser and local machine
		
		WebDriver driver;
				if(ip.equals("localhost")){
					if(browser.equals("chrome"))
					{
						driver=new ChromeDriver();
					}
					else
					{
						driver=new FirefoxDriver();
					}
				}
			else{
					try{
						URL url=new URL("http://"+ip+":4444/wd/hub");
						DesiredCapabilities dc=new DesiredCapabilities();
						dc.setBrowserName(browser);
						driver=new RemoteWebDriver(url,dc);
						}
					catch (Exception e) {
						e.printStackTrace();
						driver=new ChromeDriver();
						}
						}

		return driver;
	}
	
	public static String getXLData(String path,String sheet,int r,int c)
	{
		//reading a data from excel which will be called in Test class
		String v="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			v=w.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public static String getPropertyValue(String path,String key)
	{
		//reading a data from property file which will be called in Test class
		String v="";
		try{
				Properties p=new Properties();
				p.load(new FileInputStream(path));
				v=p.getProperty(key);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return v;
	}
	
	public static void writeResultToXL(String path,int passCount,int failCount)
	{
		//for passcount and fail count which will give result after execution.
		try{
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			w.getSheet("Sheet1").getRow(1).getCell(0).setCellValue(passCount);
			w.getSheet("Sheet1").getRow(1).getCell(1).setCellValue(failCount);
			w.write(new FileOutputStream(path));
			w.close();
		}
		catch (Exception e) {
		}
	}	
}
