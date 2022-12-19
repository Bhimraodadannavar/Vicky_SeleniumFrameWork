package com.travelling.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.Duration;
import com.spicejet.genericUtility.WebDriverUtelity;
import com.spicejet.objectRepository.VtigerCommonPage;

public class CalenderPopUp 
{
	public static void main(String[] args) 
	{
		WebDriver driver = null;
		String reqMonth = "April";
		String reqYear="2023";
		String reqDay="20";
		WebDriverUtelity webdriverUtility= new WebDriverUtelity();


		VtigerCommonPage vtiger=new VtigerCommonPage(driver);
		driver=webdriverUtility.launchingApplication("chrome", "http://rmgtestingserver:8888/index.php?action=index&module=Home", 10);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Calendar']")).click();
		driver.findElement(By.xpath("//td[@style='padding-right:0px;padding-left:10px;']/a/img")).click();

		String currentMonthAndYear = driver.findElement(By.xpath("//b[text()='December 2022']")).getText();

		String currentMonth = currentMonthAndYear.split(" ")[0];
		String currentYear = currentMonthAndYear.split(" ")[1];
		WebDriverWait wait= new WebDriverWait(driver, 10);
		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear)))
		{
			driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']")).click();
			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//td[@class='calHdr']//b"),currentMonthAndYear));
			currentMonthAndYear=driver.findElement(By.xpath("//td[@class='calHdr']//b")).getText();
			currentMonth = currentMonthAndYear.split(" ")[0];
			currentYear = currentMonthAndYear.split(" ")[1];

			
		}
		driver.findElement(By.xpath("//a[text()='"+reqDay+"']")).click();
	}

}
