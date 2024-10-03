package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.exceptions.BrowserException;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;




public class BaseTest {
	WebDriver driver ;
	DriverFactory df ; 
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected Properties prop;
	protected ResultsPage resultsPage; 
    protected ProductInfoPage productInfoPage;
    protected RegisterPage registerPage;
	protected SoftAssert softAssert;
	
	
	@BeforeTest	
	public void setUp() throws RunTimeException {
		
		df = new DriverFactory() ;
	 prop = df.initProperties();
			
	try {
		driver = df.initDriver(prop);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	loginPage = new LoginPage(driver);
	accPage = new AccountsPage(driver);
	registerPage = new RegisterPage(driver);
	// productInfoPage = new ProductInfoPage(driver);
	softAssert = new SoftAssert ();
	
	
		
	}

	 @AfterTest
	public void tearDown(  ) {
		driver.quit();
	 }
	
		
	 
}
