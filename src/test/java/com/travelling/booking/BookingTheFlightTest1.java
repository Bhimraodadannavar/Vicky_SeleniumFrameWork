package com.travelling.booking;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.spicejet.genericUtility.ExcelUtility;
import com.spicejet.genericUtility.PFileUtility;
import com.spicejet.genericUtility.PropertyFileKeys;
import com.spicejet.genericUtility.SheetName;
import com.spicejet.genericUtility.WebDriverUtelity;
import com.spicejet.objectRepository.FlightsPage;

public class BookingTheFlightTest1 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Sachin Hi
		WebDriver driver;
		//create an object for genericUtility
		ExcelUtility excelUtility= new ExcelUtility();
		PFileUtility pFileUtility= new PFileUtility();
		WebDriverUtelity webdriverUtility=new WebDriverUtelity();
		
		//open propertyFile
		pFileUtility.openproprtyfile();
		
		//get the data from the propertyFile
		String browser = pFileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url = pFileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString());
		long timeOut = Long.parseLong(pFileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString()));
		//open the excelfile
		excelUtility.openExcel();
		//get Data from excel
		String from = excelUtility.getDataFromExcel(SheetName.BOOKINGFLIGHT.getSheeCelltName(),2,1);
		//System.out.println(from);
		Thread.sleep(2000);
		String to = excelUtility.getDataFromExcel(SheetName.BOOKINGFLIGHT.getSheeCelltName(),2,2);
		//System.out.println(to);
		
		//launch the application
		driver = webdriverUtility.launchingApplication(browser, url, timeOut);
		
		//POM class objectcreation
		FlightsPage flightPage=new FlightsPage(driver);
		
		
		flightPage.clickOnRoundtripButton();
		flightPage.click1FromIntoTextField1();
		flightPage.sendFromIntoTextField2(from);
		
		flightPage.sendToIntoTextField3();
		
		flightPage.sendToIntoTextField4(to);
		Thread.sleep(4000);
		flightPage.clickOnDepartureDate();
		//Thread.sleep(4000);
		flightPage.selectDateInDecemberMonth();
	    flightPage.clickOnReturnDate();
//		flightPage.clickOnReturnDate();
//		
//		flightPage.selectDateInReturnDecemberMonth();
//		flightPage.clickOnPassengersDropDown();
//		flightPage.clickOnChildren();
//		flightPage.clickOnPassengersDropDown();
//		flightPage.clickOnSearchFlightButton();
//		
//				
//		
//		
//		
//		

	}
}
