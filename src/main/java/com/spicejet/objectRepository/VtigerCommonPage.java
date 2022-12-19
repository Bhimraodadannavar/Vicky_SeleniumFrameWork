package com.spicejet.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCommonPage 
{
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement Calender;
	
	
	public VtigerCommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	
	
	public void clickOnCalender()
	{
		Calender.click();
		
	}

}
