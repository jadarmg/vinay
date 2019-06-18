package DataDriven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Optimized;
import com.excel.utility.Xls_Reader;

public class Test1 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InvalidFormatException, FileNotFoundException, IOException, Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://reg.ebay.com/reg/PartialReg?acntType=personal");

		
		Xls_Reader reader=new Xls_Reader("./workbook/workbook.xlsx");
	
		
		int rowCount=reader.getRowCount("Test");
	
		
		for(int rownum=2;rownum<=rowCount;rownum++)
		{
			System.out.println("*********************");
			String firstname = reader.getCellData("Test", "firstname",rownum);
			System.out.println(firstname);
			
			String lastname = reader.getCellData("Test", "lastname",rownum);
			System.out.println(lastname);
			
			String email = reader.getCellData("Test", "email",rownum);
			System.out.println(email);
			
			String Password = reader.getCellData("Test", "Password",rownum);
			System.out.println(Password);
			
			driver.findElement(By.id("firstname")).clear();
			driver.findElement(By.id("firstname")).sendKeys(firstname);
			Thread.sleep(1000l);
			
			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.id("lastname")).sendKeys(lastname);
			Thread.sleep(1000l);
			
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(email);
			Thread.sleep(1000l);
			
			driver.findElement(By.id("PASSWORD")).clear();
			driver.findElement(By.id("PASSWORD")).sendKeys(Password);
			driver.findElement(By.className("checkbox__control")).click();
		}
		

	}

}
