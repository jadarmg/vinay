package DataDriven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.excel.utility.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{  
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException 
	{
		String firstname = ReadExcel.getExcelValues("./workbook/workbook.xlsx","Test",1,0);
		System.out.println(firstname);
		
		
		
		/*String lastname = ReadExcel.getExcelValues("./workbook/workbook.xlsx","Test",1,1);
		System.out.println(lastname);
		
		String mailid = ReadExcel.getExcelValues("./workbook/workbook.xlsx","Test",1,2);
		System.out.println(mailid);
		
		String password = ReadExcel.getExcelValues("./workbook/workbook.xlsx","Test",1,3);
		System.out.println(password);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://reg.ebay.com/reg/PartialReg?acntType=personal");
		
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		Thread.sleep(1000l);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		Thread.sleep(1000l);
		driver.findElement(By.id("email")).sendKeys(mailid);
		Thread.sleep(1000l);
		driver.findElement(By.id("PASSWORD")).sendKeys(password);
		
		driver.findElement(By.className("checkbox__control")).click();*/

	}

}
