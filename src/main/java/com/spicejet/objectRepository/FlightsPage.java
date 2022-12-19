package com.spicejet.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spicejet.genericUtility.WebDriverUtelity;

public class FlightsPage 
{
	@FindBy(xpath="//div[@data-testid='round-trip-radio-button']/div/*[name()='svg']/*")
	private WebElement roundtrip;
	@FindBy(xpath="//div[text()='From']")
	private WebElement fromTextField1;
	@FindBy(xpath="//div[text()='From']/..//input")
	private WebElement fromTextField2;

	@FindBy(xpath="//div[text()='To']/..")
	private WebElement toTextField3;
	@FindBy(xpath="//div[text()='To']/..//input")
	private WebElement toTextField4;


	@FindBy(xpath="//div[text()='Departure Date']")
	private WebElement departureCalender;
	@FindBy(xpath="//div[normalize-space(text())='January']/../following-sibling::div/descendant::div[text()='6']")
	private WebElement selectDateInMonthofDec;
	@FindBy(xpath="//div[text()='Return Date']")
	private WebElement returnCalender;
	@FindBy(xpath="//div[text()='December ']/../../descendant::div[text()='10']")
	private WebElement selectDateInReutnMonthofDec;
	@FindBy(xpath="//div[text()='Passengers']")
	private WebElement passengersDropDown;
	@FindBy(xpath="//div[@data-testid='Children-testID-plus-one-cta']")
	private WebElement clickOnChildren;
	@FindBy(xpath="//div[@data-testid='home-page-flight-cta']")
	private WebElement searchFlight;



	public FlightsPage (WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	public void  clickOnRoundtripButton()
	{
		roundtrip.click();
	}
	public void  click1FromIntoTextField1()
	{
		fromTextField1.click();
	}
	public void  sendFromIntoTextField2(String text)
	{
		fromTextField2.sendKeys(text);
	}

	public void  sendToIntoTextField3()
	{
		toTextField3.click();
	}


	public void  sendToIntoTextField4(String text)
	{
		toTextField4.sendKeys(text);
	}
	public void  clickOnDepartureDate()
	{
		departureCalender.click();
	}
	public void  selectDateInDecemberMonth()
	{
		selectDateInMonthofDec.click();
	}
	public void  clickOnReturnDate()
	{
		returnCalender.click();
	}
	public void  selectDateInReturnDecemberMonth()
	{
		selectDateInReutnMonthofDec.click();
	}
	public void  clickOnPassengersDropDown()
	{
		passengersDropDown.click();
	}
	public void  clickOnChildren()
	{
		clickOnChildren.click();
	}
	public void  clickOnSearchFlightButton()
	{
		searchFlight.click();
	}

}






