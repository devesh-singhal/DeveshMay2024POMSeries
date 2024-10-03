package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.qa.opencart.errors.ApplicationError;


public class DriverFactory {
	
	WebDriver driver ;
	Properties prop ;
	
	public WebDriver initDriver(Properties prop) throws Exception {
		
	String browserName = prop.getProperty("browser"); 
	
		System.out.println("browser name is .." +  browserName);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
				
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		case "safari":
			driver = new SafariDriver();
			break;


		default:
			System.out.println(ApplicationError.INVALID_BROWSER_MESG +browserName); 
			throw new BrowserException (ApplicationError.INVALID_BROWSER_MESG  ) ;
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	
	/**
	 * this method is used to initialize the properties from the config file
	 * @return
	 */
	
	public Properties initProperties( ) {
		
		prop = new Properties();
		
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("C:\\Users\\Devesh\\eclipse-workspace\\May2024POMSeries\\src\\test\\resources\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return prop;
		}
	}
	
	
	
	
	

