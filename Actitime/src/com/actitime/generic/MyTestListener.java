package com.actitime.generic;

//import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestListener implements ITestListener
{
	
	public static int executionCount, passCount, failCount, skipCount=0;

	@Override
	public void onTestStart(ITestResult result) 
	{
		executionCount++;
		Reporter.log(result.getName()+" script exceution starts: " +new Date(), true);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		passCount++;
		Reporter.log(result.getName()+ "script is Passed", true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		failCount++;
		Reporter.log(result.getName()+ "script is failed" , true);
		
		TakesScreenshot ts = (TakesScreenshot) BaseLib.driver;
		File srcfile= ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/"+result.getName()+".png");
		
		try 
		{
			Files.copy(srcfile, destFile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Reporter.log("Screenshot has been taken" , true);
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		skipCount++;
		Reporter.log(result.getName()+" Script is skipped", true);
		
	}
     @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		Reporter.log("Framework executed starts: " +new Date(), true);
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		Reporter.log("Framework execution ends" , true);
		Reporter.log("Total Scripts executed:"+executionCount , true);
		Reporter.log("Total Scripts Pass:"+passCount , true);
		Reporter.log("Total Scripts Failed:"+failCount , true);
		Reporter.log("Total Scripts skipped:" +skipCount , true);
		
		
	}

}
