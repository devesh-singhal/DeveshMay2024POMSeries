package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver ;
	private ElementUtil eleUtil;
	
	//1. private By locators : page objects
	private By username = By.id("input-email") ;
	private By password = By.id("input-password") ;
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By logo = By.cssSelector("img.img-responsive");
	private By registerLink = By.linkText("Register");
			
	
	
	
	//2. Public page constructors:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil (driver);
		
	}
	
	
	
	
	
	
	
	//3. Public page Actions/Methods
	public String getLoginPageTitle() {
		
	String title =	eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
    System.out.println("login page title: "  + title);
     return title;
	}
	
	
	
	public String getLoginPageURL() {
		String url =eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL , AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page title: "  + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);
		
	}
	
	public boolean isLogoDisplayed() {
		return eleUtil.isElementDisplayed(logo);
		
	}
	
	
	public AccountsPage doLogin (String userName, String pwd) throws InterruptedException {
		   eleUtil.waitForElementVisible(username, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(userName);
		
	       eleUtil.doSendKeys(password, pwd);
	     
		   eleUtil.doClick(loginBtn);
          return new AccountsPage(driver);
	}
	
	
	public RegisterPage navigateToRegisterPage() throws InterruptedException {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	
	
	
	
	
}
