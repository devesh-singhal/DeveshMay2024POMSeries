package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil ;
	
	private By searchHeader = By.cssSelector("div#content h2");
	private By results = By.cssSelector("div.product-thumb");
	
    public ResultsPage(WebDriver driver) {
	 this.driver = driver;
	 eleUtil = new ElementUtil (driver);
 }

    
    public String getSearchHeader() {
    	String searchHeaderValue = eleUtil.waitForElementVisible(searchHeader, AppConstants.DEFAULT_SHORT_TIME_OUT).getText() ;
    	return searchHeaderValue ;
    	
    }
    
    
    public int getSearchResultsCount() {
    	 return eleUtil.waitForElementsVisible(results, AppConstants.DEFAULT_SHORT_TIME_OUT).size();
    	 
    }
    
    public ProductInfoPage selectProdcut(String productName) throws InterruptedException {
    	eleUtil.doClick(By.linkText(productName));
    	return new ProductInfoPage(driver) ; 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
