package com.spicejet.genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;

public class WebDriverUtelity 
{
	WebDriver driver;
	WebElement element;
	Actions act;
	Select sel;
	public WebDriver launchingApplication(String browser,String url,long timeOut)
	{
		if(browser.equals("chrome"))
		{

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);

		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new FirefoxDriver();
		}
		else 
		{
			System.out.println("please enter valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		return driver;

	}
	/**
	 * slect rhe element byvisible text
	 */
	public void selectByVisibleText(WebElement element,String text)
	{
		sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * doubleclickon the element
	 */
     public void doubleClickOnTheElement()
     {
    	 act= new Actions(driver);
    	 act.doubleClick(element);
     }

}
