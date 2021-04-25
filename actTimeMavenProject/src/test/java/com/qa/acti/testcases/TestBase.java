package com.qa.acti.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.acti.base.DriverScript;
import com.qa.acti.pages.EnterTimePage;
import com.qa.acti.pages.LoginPage;
import com.qa.acti.pages.TaskListPage;

public class TestBase extends DriverScript{
	
	LoginPage lPage;
	EnterTimePage etPage;
	TaskListPage tlPage;
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest logger;
	
	
	public TestBase() {
			super();
	
	}
	
	@BeforeClass
	public void preClass(){
		
		 htmlReporter = new ExtentHtmlReporter("./actiReport/actTimeTestReport.html");
		 extent = new ExtentReports();
		 extent.attachReporter(htmlReporter);
		
	}
	@BeforeMethod
	public void preTest(){
		
		initialization();
		lPage = new LoginPage();
		etPage = new EnterTimePage();
		tlPage = new TaskListPage();
	
		
	}
	@AfterMethod
	public void postTest(){
		
		extent.flush();
		driver.close();
	}

}
