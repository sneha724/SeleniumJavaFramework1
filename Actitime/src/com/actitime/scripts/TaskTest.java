package com.actitime.scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.actitime.features.LoginFeatures;
import com.actitime.features.TaskFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class TaskTest extends BaseLib
{

	@Test
	public void createCustomer() throws InterruptedException
	{
		ExcelUtilities eu = new ExcelUtilities("./testdata/testdata.xlsx");
		String username = eu.readData("Sheet1", 3, 1);
		String password = eu.readData("Sheet1" , 3, 2);	 
		
		LoginFeatures If = new LoginFeatures(driver);
		If.login(username, password);
		
		String customername = eu.readData("Sheet1" , 3, 3);	
		TaskFeatures tf = new TaskFeatures(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		tf.clickonTask();
		tf.clickOnProjCustLink();
		tf.createcustomer(customername);
		tf.verifyCreateCustomer(customername);
		Thread.sleep(3000);
	}
	
	@Test()
	public void deleteCustomer()
	{
		ExcelUtilities eu = new ExcelUtilities("./testdata/testdata.xlsx");
		String username = eu.readData("Sheet1", 3, 1);
		String password = eu.readData("Sheet1" , 3, 2);	 
		
		LoginFeatures If = new LoginFeatures(driver);
		If.login(username, password);
		
		String customername = eu.readData("Sheet1" , 3, 3);
		TaskFeatures tf = new TaskFeatures(driver);
		tf.clickonTask();
		tf.clickOnProjCustLink();
		tf.deltcust(customername);
		tf.verifydeletCust(customername);
	}
	
	@Test(enabled=false)
	public void createProject() throws InterruptedException
	{
		ExcelUtilities eu = new ExcelUtilities("./testdata/testdata.xlsx");
		String username = eu.readData("Sheet1", 3, 1);
		String password = eu.readData("Sheet1" , 3, 2);	 
		
		LoginFeatures If = new LoginFeatures(driver);
		If.login(username, password);
		
		String projectName = eu.readData("Sheet1" , 5, 5);
		String customername = eu.readData("Sheet1" , 3, 3);
		TaskFeatures tf = new TaskFeatures(driver);
		tf.clickonTask();
		Thread.sleep(2000);
		tf.clickOnProjCustLink();
		Thread.sleep(2000);
		tf.createProject(projectName, customername);
		
	}
	@Test(enabled=false)
	public void deleteProject()
	{
		ExcelUtilities eu = new ExcelUtilities("./testdata/testdata.xlsx");
		String username = eu.readData("Sheet1", 3, 1);
		String password = eu.readData("Sheet1" , 3, 2);	 
		
		LoginFeatures If = new LoginFeatures(driver);
		If.login(username, password);
		
		String projectName = eu.readData("Sheet1" , 5, 5);
		TaskFeatures tf = new TaskFeatures(driver);
		tf.clickonTask();
		tf.clickOnProjCustLink();
		tf.deleteProject(projectName);
		
	}
}
