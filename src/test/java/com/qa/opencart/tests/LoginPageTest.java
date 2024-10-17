package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;

public class LoginPageTest extends BaseTest {

	
	private String accountPageTitle;

	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
			}
	
	
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
		
		
	}
	
	
	@Test
	
public void forgotPwdLinkExistTest() {
		Assert.assertTrue (loginPage.isForgotPwdLinkExist() );
	}
	
	@Test
	public void logoExistTest() {
		Assert.assertTrue (loginPage.isLogoDisplayed()) ;	
		
	}
	
	@Test
	public void loginTest() {
		try {
			AccountsPage accountPageTitle = loginPage.doLogin(prop.getProperty("username"), System.getProperty("password"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //Assert.assertEquals(accountPageTitle, AppConstants.ACCOUNT_PAGE_TITLE);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
