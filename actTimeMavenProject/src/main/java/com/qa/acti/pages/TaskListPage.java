package com.qa.acti.pages;

//import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import com.qa.acti.base.DriverScript;
import com.qa.acti.utility.Helper;

public class TaskListPage extends DriverScript {
	
	//page elements
	
	@FindBy(xpath="//div[@class = 'title ellipsis' ]") WebElement addNewBtn;
	@FindBy(xpath="//div[@class='item createNewCustomer']") WebElement newCustomerBtn;
	@FindBy(xpath="//input[@class='inputFieldWithPlaceholder newNameField inputNameField']") WebElement enterCustomerNameTB;
	@FindBy(xpath="//textarea[@class='textarea' and @placeholder='Enter Customer Description']") WebElement custDescriptionTA;
	@FindBy(xpath="//div[text()='Create Customer']") WebElement createCustomerBtn;
	
	/*@FindBy(xpath="//div[@class='item createNewProject']") WebElement newProjectLink;
	@FindBy(xpath="//div[@class='item createNewTasks']") WebElement newTaskLink;
	@FindBy(xpath="//div[@class='item importTasks']") WebElement importTaskLink;*/
	//item importTasks
	
	
	//PAge initialization
	public TaskListPage(){
		
		PageFactory.initElements(driver,this);
	}
	

	//Page actions
	
	public void verifyAddNewBtn(){
		
		Helper.highLightElement(addNewBtn);
		addNewBtn.click();
		
	}
	public void verifyNewCustomerBtn(){
		
		Helper.highLightElement(newCustomerBtn);
		newCustomerBtn.click();
		
	}
	public void verifyEnterCustomerNameTB(String customerName){
		
		Helper.highLightElement(enterCustomerNameTB);
		enterCustomerNameTB.sendKeys(customerName);
	}
	
	public void verifyCustDescriptionTA(String description){
		
		Helper.highLightElement(custDescriptionTA);
		custDescriptionTA.sendKeys(description);
	}
	
	public void verifyCreateCustomerBtn(){
		
		Helper.highLightElement(createCustomerBtn);
		createCustomerBtn.click();
	}
}
