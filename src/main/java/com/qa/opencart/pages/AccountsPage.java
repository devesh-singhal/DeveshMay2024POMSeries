package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By logoutLink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	
	public AccountsPage(WebDriver driver ) {
		this.driver = driver;
		eleUtil = new ElementUtil (driver);
		
	}
	
	
	public String getAccountsPageTitle() {
  String title =	eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNT_PAGE_TITLE ,  AppConstants.DEFAULT_SHORT_TIME_OUT);
	    System.out.println("Account page title: "  + title);
	     return title;
	
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.isElementDisplayed(logoutLink);
		
	}
		
	
		public int getTotalAccountsPageHeader() {
			return eleUtil. waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
			
			
		 	}	
		
		 public List<String> getAccountPageHeaders( ) {
	
	List<WebElement>  headersList =  eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
	List<String> headerValueList = new ArrayList<String>();
	  
	    for (WebElement e: headersList) {
	    String header =	e.getText();
	    headerValueList.add(header);
	    
	    }
	    	return headerValueList ;
	    }
	
	
	
  public ResultsPage doSearch(String searchkey) throws InterruptedException  {
	  System.out.println("Search Key ====>>>" + searchkey);
	  
	  
	  WebElement element = eleUtil.waitForElementVisible(search, 2);
			  element.clear();
	           element.sendKeys(searchkey);
	           Thread.sleep(1000);
	   
	  eleUtil.doClick(searchIcon);
	  Thread.sleep(2000);
   return new ResultsPage(driver) ;
		
       }


	
}
	
