package com.qa.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScript {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public DriverScript(){
		
		try{
			
			prop = new Properties();
			File src = new File("./actiConfig/config.properties");
			//File src = new File("C:\\workspace\\MavenProject\\actiConfig\\config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
			//https://demo.actitime.com
		}
		catch (Exception e)
		{
			System.out.println("File Not Found "+e.getMessage());
		}
	}
	public static void initialization(){
		
		//Writing codes to launch the browser
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\workspace\\MavenProject\\actiBrowser\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "./browsers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String url = prop.getProperty("URL");
		driver.get(url);
		
	}
	

}
