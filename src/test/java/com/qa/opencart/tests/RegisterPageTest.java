package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void regSetup() throws InterruptedException {
	registerPage = loginPage.navigateToRegisterPage();
		
		
	}
	
	public String getRandomEmail () {
		return "uiautomation" +System.currentTimeMillis()+"@open.com" ;
	}
	
	
	
	
	@Test 
	public void registerTest()  {
	   
		
			Assert.assertTrue(registerPage.userRegistration("Singhal", "Kumar", getRandomEmail(),  "8888855550", "Dugga@135#", "Dugga@135#", "yes"));
		
		}
		
		
		
		
		
	}

