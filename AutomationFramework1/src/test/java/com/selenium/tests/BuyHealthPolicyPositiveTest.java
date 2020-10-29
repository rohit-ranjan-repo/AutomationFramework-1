package com.selenium.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.selenium.pages.BuyHealthPolicyPage;


import com.selenium.setup.DriverSetup;

import com.selenium.setup.ExcelUtils;

import com.selenium.setup.ScreenShotUtils;

public class BuyHealthPolicyPositiveTest  extends DriverSetup{

	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	String tcName = "BuyHealthPolicyPositiveTest";
	static boolean  flag = true;

	

	@BeforeClass

	public void setUp() throws IOException {
		flag = ExcelUtils.getRunPermission("agent",tcName);
		if(flag)
		{
			System.out.println(tcName + " execution started");
			this.driver = getDriver();	
			ExtentHtmlReporter reporter=new ExtentHtmlReporter("./extent-report/"+tcName+"_"+System.currentTimeMillis()+".html");

			extent = new ExtentReports();

			extent.attachReporter(reporter);

			logger=extent.createTest(tcName);

		}
		else
		{
			try
			{
			Thread.currentThread().stop();
			}
			catch(Exception e)
			{
				
			}
		}








	}

	@Test(dataProvider="healthPolicyData",description="To Buy a new health policy",groups= {"SmokeTest"})

	public void  testValidCustomerDetails(String birthDate, String mobileNumber,String name,String policyHolderphoneNumber,String email, String lblAssert) throws InterruptedException {


		logger.log(Status.INFO, "testValidCustomerDetails started");


		BuyHealthPolicyPage buyHealthPolicy = PageFactory.initElements(driver, BuyHealthPolicyPage.class);
		buyHealthPolicy.clickHealth();
		logger.log(Status.PASS, "clickHealth");
		buyHealthPolicy.clickSelf();
		logger.log(Status.PASS, "clickSelf");
		buyHealthPolicy.clickGetPlan();
		logger.log(Status.PASS, "clickGetPlan");
		buyHealthPolicy.setBirthDate(birthDate);
		logger.log(Status.PASS, "setBirthDate");
		Thread.sleep(2000);
		buyHealthPolicy.setMandMobileNo(mobileNumber);
		logger.log(Status.PASS, "setMandMobileNo");
		buyHealthPolicy.clickSeePlan();
		logger.log(Status.PASS, "clickSeePlan");
		buyHealthPolicy.clickBuyNowButton();
		logger.log(Status.PASS, "clickBuyNowButton");
		buyHealthPolicy.clickIamGoodButton();
		logger.log(Status.PASS, "clickIamGoodButton");
		buyHealthPolicy.setName(name);
		logger.log(Status.PASS, "setName");
		buyHealthPolicy.setEmailId(email);
		logger.log(Status.PASS, "setEmailId");
		buyHealthPolicy.clickTC();
		logger.log(Status.PASS, "clickTC");
		Assert.assertEquals(buyHealthPolicy.getLabel(), lblAssert);
		logger.log(Status.PASS, "Title verified");


	}

	
	
	@Test(description="Proceed to pay",dependsOnMethods = { "testValidCustomerDetails" })

	public void  proceedToPay() {


		logger.log(Status.INFO, "proceedToPay started");


		BuyHealthPolicyPage buyHealthPolicy = PageFactory.initElements(driver, BuyHealthPolicyPage.class);
		
		buyHealthPolicy.clickPayButon();
		logger.log(Status.PASS, "clickPayButon");

	}


	//This method will fetch the data from ExcelUtils method and pass the value to the data provider name according to the sheet name provided

	@DataProvider(name="healthPolicyData")

	public Object[][] getExcelData() throws Exception {

		Object[][] SheetData=ExcelUtils.readExcelData("agent",tcName);
		System.out.println("1111111" + SheetData);
		return SheetData;

	}

	@AfterMethod

	public void tearDown(ITestResult result) throws IOException
	{

		if(result.getStatus()==ITestResult.FAILURE)
		{

			String temp=ScreenShotUtils.getScreenshot(driver);

			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}

		extent.flush();
		
	}

	@AfterClass

	public void closeBrowser(){

		driver.quit();

	}









}



