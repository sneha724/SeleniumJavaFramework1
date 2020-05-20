package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	
	public static WebDriver driver;
	
	@BeforeMethod 
	@Parameters({"browser", "baseUrl"})
	public void preCondition(String browserName, String url)
	{
		driver= BrowserFactory.launchBroswer(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	@AfterMethod
	public void postcondition()
	{
		driver.close();
		Reporter.log("Browser Closed" , true);
	}
	
	
	

}
