package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageobjects.EnterTimeTrackPage;

public class TimeTrackFeatures
{
WebDriver driver;
EnterTimeTrackPage ettp;

public TimeTrackFeatures(WebDriver driver)
{
	
	this.driver=driver;
	ettp= new EnterTimeTrackPage(driver);
}
public void verifyEnterTimeTrackPage()
{
	String actualText = ettp.getettpTitleEle().getText();
	String expectedText= "Enter Time-Track";
	
	Assert.assertEquals(actualText, expectedText);
	
	 String actualTitle = driver.getTitle();
	 String expectedTitle= "actiTIME - Enter Time-Track";
	 
	 Assert.assertEquals(actualTitle, expectedTitle);
	 Reporter.log("EnterTimeTrackPage is Verified" , true);
}






}
