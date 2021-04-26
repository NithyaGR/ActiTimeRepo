package com.qa.acti.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;



public class TestCreateNewCustomer extends TestBase{
	
	@Test
	
	public void testCreateNewCustomer() throws Exception{
		
		logger = extent.createTest("Create New Customer");
		lPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
		logger.log(Status.PASS, "Logged into the Application");
		etPage.clickTaskMenu();
		logger.log(Status.INFO,"Clicked Task Menu");
		tlPage.verifyAddNewBtn();
		logger.log(Status.INFO,"Clicked Add New Button");
		tlPage.verifyNewCustomerBtn();
		logger.log(Status.INFO,"Clicked New Customer Button");
		tlPage.verifyEnterCustomerNameTB("TJActi51");
		logger.log(Status.INFO,"Entered Customer Name");
		tlPage.verifyCustDescriptionTA("Retail");
		logger.log(Status.INFO,"Entered Customer Description");
		tlPage.verifyCreateCustomerBtn();
		logger.log(Status.PASS,"Clicked Create Customer Button");
		etPage.clickLogoutLink();
		logger.log(Status.INFO,"Logged Out the Application");
		
		
		
		
	}

}
