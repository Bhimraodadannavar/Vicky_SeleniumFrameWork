package com.travelling.booking;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysql.cj.jdbc.Driver;
import com.spicejet.genericUtility.WebDriverUtelity;

public class BrokenLinkTest
{
	public static void main(String[] args) throws IOException 
	{
		
		WebDriverUtelity webdriverUtility= new WebDriverUtelity();
		WebDriver driver=webdriverUtility.launchingApplication("chrome", "http://flipkart.com", 10);
		driver.findElement(By.xpath("//button[text()='✕']")).click();

		List<WebElement> listOflinks = driver.findElements(By.xpath("//a"));
		for(int i=0; i<listOflinks.size();i++)
		{
			String url = listOflinks.get(i).getAttribute("href");
			System.out.println(url);
			try {
				
		
			URL u = new URL(url);
			URLConnection urlConnection = u.openConnection();
			HttpsURLConnection httpConnection = (HttpsURLConnection)urlConnection;
			int statuscode = httpConnection.getResponseCode();
			if(statuscode!=200)
			{
				System.out.println("Broken link=====>"+url+"======>"+httpConnection.getResponseMessage());
			}
			
		}
		catch(Exception e){
			System.out.println("something wrong with the url"+url);
		}
		
	}

}
}