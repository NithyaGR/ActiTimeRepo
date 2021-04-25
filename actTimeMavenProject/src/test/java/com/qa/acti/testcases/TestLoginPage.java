package com.qa.acti.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TestLoginPage extends TestBase{
	
	@Test(priority =1)
	
	public void testVerifyPageTitle(){
		
		String ActualTitle = lPage.verifyPageTitle();
		System.out.println("Title of the page is :"+ActualTitle);
		SoftAssert sa = new SoftAssert();
		String Expected = "actiTIME - Enter Time-Track";
		sa.assertEquals(ActualTitle, Expected);
	}
	
	@Test (priority =2 )
	public void testActiLogoDisplayed(){
		
		boolean flag = lPage.verifyActiLogoDisplayed();
		System.out.println("Logo is Displayed :"+flag);
		
	}
	@Test (priority = 3, dataProvider = "testData")
	public void testLoginToApplication(String userName, String password) throws Exception{
		
		lPage.loginToApplication(userName, password);
		//lPage.loginToApplication();
		
		Thread.sleep(3000);
		etPage.clickLogoutLink();
		
	}
	/*@Test (priority = 4)
	public void testKeepLoginCB(){
		
	}*/
   @DataProvider (name = "testData")
	
	public String[][] readExcel() throws IOException
	{
		
		//File srcFile = new File("C:\\workspace\\MavenProject\\src\\main\\java\\com\\qa\\acti\\utility\\TestData.xlsx");
		File srcFile = new File("C:\\workspace\\actTimeMavenProject\\actiTestData\\TestData.xlsx");
		FileInputStream fis1 = new FileInputStream(srcFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis1);
		XSSFSheet xlSheet = wb.getSheetAt(0);
		int rows = xlSheet.getLastRowNum()+1;
		int columns = 2;
		String inputData [][] = new String [rows][columns];
				
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<2; j++){
				String rowData = wb.getSheetAt(0).getRow(i).getCell(j).toString();
				inputData[i][j]= rowData;
				String colData = wb.getSheetAt(0).getRow(i).getCell(j).toString();
				inputData[i][j]= colData;
															}
		}
		wb.close();
		return inputData;
		
		
		
		
		
	}

}
