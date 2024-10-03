package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver ;
	 private ElementUtil eleUtil;

	 private By firstName = By.id("input-firstname");
	 private By lastName = By.id("input-lastname");
	 private By email = By.id("input-email");
	 private By telephone = By.id("input-telephone");
	 private By password = By.id("input-password");
	 private By confirmPassword = By.id("input-confirm");
	 
	 private By susbcribeYes = By.xpath("(//label[@class='radio-inline'])[1]/input[@type='radio']");
	 private By susbcribeNo = By.xpath("(//label[@class='radio-inline'])[2]/input[@type='radio']");
	 private By agreeCheckBox = By.xpath("//input[@type='checkbox']");
	 private By continueButton = By.xpath("//input[@class='btn btn-primary' and @type='submit']");
	 
	 private By logoutLink = By.linkText("Logout");
	 private By registerLink = By.linkText("Register");
	private By successMessage =  By.cssSelector("div#content h1") ;
	 
	
	 
	public RegisterPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil (driver);
			
		}

	public boolean userRegistration (String firstName, String lastName, String email,String telephone, String password, String confirmPassword  , String subscribe) {
		eleUtil.waitForElementVisible(this.firstName, AppConstants.DEFAULT_SHORT_TIME_OUT ).sendKeys(firstName);
	
		
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmPassword, confirmPassword);
	
		
	 if (subscribe.equalsIgnoreCase ("yes") ) {
		 try {
			eleUtil.doClick(susbcribeYes);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 } else {
		 try {
			eleUtil.doClick(susbcribeNo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		
	  try {
		eleUtil.doClick(agreeCheckBox);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		eleUtil.doClick(continueButton);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	// WebElement successMessage = driver.findElement(By.cssSelector("div#content h1")) ;
	  //successMessage.getText();
	  
	    String finalMessage =  eleUtil.waitforVisibilityOfElement(successMessage, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
	    System.out.println(finalMessage);
	 
	 if (finalMessage.contains(AppConstants.USER_REGISTER_SUCCESS_MESSAGE))  {
		 try {
			eleUtil.doClick(logoutLink);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			eleUtil.doClick(registerLink);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return true;
		 
	 } else {
		 
		 return false;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
