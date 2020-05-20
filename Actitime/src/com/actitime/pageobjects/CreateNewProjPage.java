package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

  public class CreateNewProjPage 
 {
  @FindBy(name="customerId")
  private WebElement selectCustmer;
  
  @FindBy(name="name")
  private WebElement projectName;
  @FindBy(name="createProjectSubmit")
  private WebElement projSubmitBtn;
	
public CreateNewProjPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
   public void selectcustomeradded(String customername)
   {
	   Select sel = new Select(selectCustmer);
	   sel.selectByVisibleText(customername);
   }
   
public WebElement getSelectCustmer() 
{
	return selectCustmer;
}
public WebElement getProjectName() 
{
	return projectName;
}
public WebElement getProjSubmitBtn() 
{
	return projSubmitBtn;
}

	
}
   
   
	
	

