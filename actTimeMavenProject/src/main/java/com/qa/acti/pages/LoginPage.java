package com.qa.acti.pages;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;*/

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.acti.base.DriverScript;
//import com.qa.acti.utility.DataProviderReadExcel;
import com.qa.acti.utility.Helper;

public class LoginPage extends DriverScript{

//  **************************** Page Elements ************************************************************ //
	
	@FindBy(xpath="//div[@class='atLogoImg']") WebElement actiLogo;
	@FindBy(id="username") WebElement userNameTB;
	@FindBy(name="pwd") WebElement passwordTB;
	@FindBy(id="loginButton") WebElement loginBtn;
	@FindBy(id="keepLoggedInCheckBox") WebElement KeepLoginCB;
	String rowData;
	String colData;
	
	
	// Page Initialization
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Page Actions
	
	public boolean verifyActiLogoDisplayed(){
		Helper.highLightElement(actiLogo);
		
		return actiLogo.isDisplayed();
		
	}
	
	
	public void loginToApplication(String userName, String password) throws Exception{
	
		Helper.highLightElement(userNameTB);
		userNameTB.sendKeys(userName);
		Helper.highLightElement(passwordTB);
		passwordTB.sendKeys(password);
		Helper.highLightElement(loginBtn);
		loginBtn.click();
		Thread.sleep(3000);
		System.out.println("Current Page Title: "+driver.getTitle());
		
	}
	
	public String verifyPageTitle(){
		
		return driver.getTitle();
	}
	
	public boolean verifyKeepLoginCB(){
		
		return KeepLoginCB.isEnabled();
		
	}

	
}
