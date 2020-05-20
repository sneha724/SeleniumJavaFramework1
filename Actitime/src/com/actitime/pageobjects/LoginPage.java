package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage

{
	@FindBy(name="username")
	private WebElement unTxtBx;
	
	@FindBy(name="pwd")
	private WebElement pwTxtBx;
	
	@FindBy(xpath="//a[@id='loginButton']")
	private WebElement lgbtn;
	
	@FindBy(xpath="//span[contains(text(),'Username or Password is invalid. Please try again.')]")
	private WebElement invalidmsg;
	
	
	public LoginPage(WebDriver driver)
	{

		PageFactory.initElements(driver, this);
	}
	
	public WebElement getunTxtBx()
	{
		return unTxtBx;
	}
	
	public WebElement getpwTxtBx()
	{
		return pwTxtBx;
	}
	
	public WebElement getlgbtn()
	{
		return lgbtn;
	}
	
	public WebElement getinvalidmsg()
	{
		return invalidmsg;
	}
	

}


