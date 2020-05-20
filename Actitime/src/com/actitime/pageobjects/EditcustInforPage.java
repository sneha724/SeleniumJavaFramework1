package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditcustInforPage 
{
	@FindBy(xpath="//input[@value='Delete This Customer']")
	private WebElement DeltThisCust;
	@FindBy(id="deleteButton")
	private WebElement Deletpopup;
	
	public EditcustInforPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeltThisCust() {
		return DeltThisCust;
	}

	public WebElement getDeletpopup() {
		return Deletpopup;
	}
	
}




