package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageobjects.LoginPage;

public class LoginFeatures
{
WebDriver driver;
LoginPage lp;
	
	public LoginFeatures(WebDriver driver)
	{
		this.driver= driver;
		lp= new LoginPage(driver);
		
	}
	
	public void login(String username, String Password)
	{
		lp.getunTxtBx().sendKeys(username);
		lp.getpwTxtBx().sendKeys(Password);
		lp.getlgbtn().click();
	}
	
	public void verfiyinvalidlogin()
	{
		 String actualMsg = lp.getinvalidmsg().getText();
		 String expectedMsg= "Username or Password is invalid. Please try again.";
		 Assert.assertEquals(actualMsg, expectedMsg);
		 Reporter.log("Invalid login is verified", true);
		 
	}
}
