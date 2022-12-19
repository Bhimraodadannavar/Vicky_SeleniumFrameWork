package com.spicejet.objectRepository;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.spicejet.genericUtility.ExcelUtility;
import com.spicejet.genericUtility.IConstantPath;
import com.spicejet.genericUtility.PFileUtility;
import com.spicejet.genericUtility.PropertyFileKeys;
import com.spicejet.genericUtility.SheetName;
import com.spicejet.genericUtility.WebDriverUtelity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartFetchTheProduct 
{
	public static void main(String[] args) throws IOException 
	{
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.openExcel();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//div[text()='Top Offers']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(text(),'10%')]/preceding-sibling::div[@class='_3LU4EM']"));
	    
		
		for(int i=0; i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
			excelUtility.setDataToExcel(IConstantPath.EXCEL_PATH,SheetName.BOOKINGFLIGHT.getSheeCelltName(),i,5,elements.get(i).getText());

		}
	
	
	}

}
