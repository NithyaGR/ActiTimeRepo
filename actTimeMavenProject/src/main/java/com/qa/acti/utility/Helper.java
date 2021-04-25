package com.qa.acti.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.qa.acti.base.DriverScript;

public class Helper extends DriverScript{
	
	public static void highLightElement(WebElement ele){
	
	JavascriptExecutor js =(JavascriptExecutor)driver;

	js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;')", ele);
	
	}

}
