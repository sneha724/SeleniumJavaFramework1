package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class BrowserFactory {
	
	public static WebDriver launchBroswer(String browserName)
	{
		WebDriver driver= null;
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Chrome Launched" , true);
			
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/geckodriver.exe");
			driver= new FirefoxDriver();
			Reporter.log("Firefox launched" , true);
			
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./exefiles/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Reporter.log("IE Browser launched" , true);
		}
		
		return driver;
	}

}
