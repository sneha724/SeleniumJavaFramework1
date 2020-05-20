package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import com.actitime.features.customername;

public class ActiProjCustPage
{

	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(xpath="//table[@id='SuccessMessages']//span")
	private WebElement successmasg;
	@FindBy(xpath="//input[@name='customers[1]']")
	private WebElement deleteCust;
	@FindBy(xpath="//input[@value='Delete Selected']")
	private WebElement delSelectedCust;
	@FindBy(id="deleteButton")
	private WebElement deleBtn;
	@FindBy(xpath="//td[@id='deleteAttention']")
	private WebElement deltpopmsg;
	@FindBy(name="selectedCustomer")
	private WebElement custDropdwn;
	@FindBy(xpath="//input[@value='  Show  ']")
	private WebElement showbtn;
	@FindBy(xpath="//td[@class='selectCustomer']//input[@value='on']")
	private WebElement custlinkChkBx;
	@FindBy(xpath="//a[text()='GE Health1234']")
	private WebElement addedCustLink;
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement deletMsgConfirmation;
	@FindBy(xpath="//input[@value='Create New Project']")
	private WebElement createNewProj;
	@FindBy(xpath="//a[text()='HealthCareDemo']")
	private WebElement createdProjLink;
	@FindBy(className="successmsg")
	private WebElement projdeletedConfMsg;
	
	public ActiProjCustPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatedProjLink() {
		return createdProjLink;
	}

	public WebElement getProjdeletedConfMsg() {
		return projdeletedConfMsg;
	}

	public WebElement getCreateNewCustBtn() {
		return createNewCustBtn;
	}

	public WebElement getSuccessmasg() {
		return successmasg;
	}

	public WebElement getDeleteCust() {
		return deleteCust;
	}

	public WebElement getDelSelectedCust() {
		return delSelectedCust;
	}

	public WebElement getDeleBtn() 
	{
		return deleBtn;
	}

	public WebElement getDeltpopmsg() {
		return deltpopmsg;
	}

	public WebElement getShowbtn() {
		return showbtn;
	}

	public WebElement getCustlink() {
		return custlinkChkBx;
	}

	public WebElement getDeletMsgConfirmation() {
		return deletMsgConfirmation;
	}
	
	
	 public WebElement getCustDropdwn() {
		return custDropdwn;
	}

	public WebElement getCustlinkChkBx() {
		return custlinkChkBx;
	}

	public void deletecustomer(String customername)
	 {
		 Select sel = new Select(custDropdwn);
		 sel.selectByVisibleText(customername);
		 
		}

	public WebElement getAddedCustLink() {
		return addedCustLink;
	}

	public WebElement getCreateNewProj() {
		return createNewProj;
	}
	 
   
	
	}
	
	
	

	
	

