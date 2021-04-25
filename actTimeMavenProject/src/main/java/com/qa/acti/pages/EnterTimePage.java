package com.qa.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.acti.base.DriverScript;
import com.qa.acti.utility.Helper;

public class EnterTimePage extends DriverScript {
	@FindBy(id="container_tasks") WebElement taskMenu;
	@FindBy(xpath="//a[@id='logoutLink']") WebElement logoutLink;
	
	public EnterTimePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickTaskMenu() throws Exception{
		Thread.sleep(3000);
		Helper.highLightElement(taskMenu);
		taskMenu.click();
	}
	
	public void clickLogoutLink() throws Exception{
		
		Thread.sleep(3000);
		Helper.highLightElement(logoutLink);
		logoutLink.click();
	}
	

}
