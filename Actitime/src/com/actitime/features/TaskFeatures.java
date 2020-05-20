package com.actitime.features;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageobjects.ActiProjCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjPage;
import com.actitime.pageobjects.EditProjInformation;
import com.actitime.pageobjects.EditcustInforPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.OpenTaskPage;

public class TaskFeatures 
{
 WebDriver driver;
 EnterTimeTrackPage ettp;
 OpenTaskPage otp;
 ActiProjCustPage apcp;
 CreateNewCustPage cncp;
 EditcustInforPage ecip;
 CreateNewProjPage cnpp;
 EditProjInformation epi;
 
 
 public TaskFeatures(WebDriver driver)
 {    this.driver= driver;
	  ettp= new EnterTimeTrackPage(driver);
	  otp= new OpenTaskPage(driver);
	  apcp= new ActiProjCustPage(driver);
	  cncp= new CreateNewCustPage(driver);
	  ecip= new EditcustInforPage(driver);
	  cnpp = new CreateNewProjPage(driver);
	  epi = new EditProjInformation(driver);
 }
 public void clickonTask()
 {
	 ettp.getTaskEle().click();
 }
 
 public void clickOnProjCustLink()
 {
	 otp.getProjCustlink().click();
 }
 
 public void createcustomer(String customername)
 {
	 apcp.getCreateNewCustBtn().click();
	 cncp.getCustNameTxtBx().sendKeys(customername);
	 cncp.getCreateCustbtn().click();
 }
 
 public void verifyCreateCustomer(String customerame)
 {
	 String actualText = apcp.getSuccessmasg().getText();
	 String expectedText= "Customer \""+customerame+"\" has been successfully created.";
	 Assert.assertEquals(actualText, expectedText);	
	 Reporter.log(expectedText ,true);
 }
 
 public void deltcust(String customername)
 {
	 Select sel = new Select(apcp.getCustDropdwn());
	 sel.selectByVisibleText(customername);
	 apcp.deletecustomer(customername);
	 apcp.getShowbtn().click();
	 apcp.getAddedCustLink().click();
	 ecip.getDeltThisCust().click();
	 ecip.getDeletpopup().click();
}

 public void verifydeletCust(String expectedCustName)
 {
	 String actualText= apcp.getDeletMsgConfirmation().getText();
	 String expectedText="Customer has been successfully deleted.";
	 Assert.assertEquals(actualText, expectedText);	
	 Reporter.log(expectedText ,true);
	 
	 Select sel = new Select(apcp.getCustDropdwn());
	 List<WebElement> options = sel.getOptions();
	 for(int i=0; i< options.size(); i++)
	 {
		 String actualCustName = options.get(i).getText();
		 Assert.assertNotEquals(actualCustName, expectedCustName);
	}
	 Reporter.log(expectedText, true);
		 
 }
 public void createProject(String projectName, String customername)
 {
	 
	 apcp.getCreateNewProj().click();
	 cnpp.selectcustomeradded(customername);
	 cnpp.getSelectCustmer().click();
	 cnpp.getProjectName().sendKeys(projectName);
	 cnpp.getProjSubmitBtn().click();
 }
 public void deleteProject(String projectName)
 {
	 apcp.getCreatedProjLink().click();
	 epi.getDltProject().click();
	 epi.getDeleteProjPopupbtn().click();
	 
 }
 public void verifydeletedProject()
 {
	 String actualText = apcp.getProjdeletedConfMsg().getText();
	 String excpectedText= "Project has been successfully deleted.";
	 Assert.assertEquals(actualText, excpectedText);	
	 Reporter.log(excpectedText ,true);
 }
 
 
 
}
