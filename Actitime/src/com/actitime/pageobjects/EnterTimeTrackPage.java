package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage extends BasePage
{

	@FindBy(xpath="(//td[@class='pagetitle'])[2]")
	private WebElement ettpTitleEle;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public WebElement getettpTitleEle()
	{
		return ettpTitleEle;
	}
	
}
