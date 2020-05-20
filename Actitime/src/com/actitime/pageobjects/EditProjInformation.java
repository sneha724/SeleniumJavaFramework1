package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProjInformation
{

	@FindBy(xpath="//input[@value='Delete This Project']")
	private WebElement dltProject;
	@FindBy(id="deleteButton")
	private WebElement deleteProjPopupbtn;
	
	public EditProjInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getDltProject() {
		return dltProject;
	}

	public WebElement getDeleteProjPopupbtn() {
		return deleteProjPopupbtn;
	}
	
	
	
	
	
	
	
	
}
