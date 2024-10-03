package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	
	private static WebDriver driver;
	private By locator;
	
	 public ElementUtil(WebDriver driver) {
		 this.driver=driver;
		 
		 
	 }

	public static  void doSendKeys(By locator, String value) {
		 ((org.openqa.selenium.WebElement) getElement (locator)).sendKeys(value);
		 
	 }
	 
	public  void doSendKeys(By locator, CharSequence[] value) {
		 ((org.openqa.selenium.WebElement) getElement (locator)).sendKeys(value);
		 
	 }
	
	
	public  void doSendKeys(String value, String value1) {
		 ((org.openqa.selenium.WebElement) getElement (locator)).sendKeys(value1);
		 
	 }
	public  void doClick(By locator) throws InterruptedException {
		//Thread.sleep(3000);
		 getElement(locator).click();
		 
	 }
	 
public String doElementGetAttribute (By locator, String attrName) {
		
		return getElement(locator).getAttribute(attrName);
		
}
	
	   public static  WebElement getElement(By locator) {
		   
		  return  driver.findElement(locator);
	 }
	
		   public  int getElementsCount(By locator) {
				return getElements (locator).size();
				
				
			}
		
		public static List <WebElement> getElements(By locator) {
			   
			  return  driver.findElements(locator);
		 }

		public void printElementTextList(By locator) {
			
			List<String> eleList =   getElementTextList (locator) ;
			for (String s :eleList ) {
				System.out.println(s);
			}
		}
		
		public  List<String> getElementTextList (By locator ) {
			List <WebElement >eleList = getElements(locator);
			List <String> eleTextList = new ArrayList <String>();
			
			
			 
	 		for (WebElement e : eleList ) {
				String eleText = e.getText();
				if (eleText.length()!=0) {
					eleTextList.add(eleText);	
				}
				
			}
	 		   return eleTextList;
		}
		
		public  boolean isElementPresent (By locator, int expectedElementCount) {
			if (getElementsCount (locator) == expectedElementCount) {
				return true;
			}
			 return false;
			}
				

		
		public  boolean isElementPresent (By locator) {
			if (getElementsCount (locator) ==1) {
				return true;
			}
			 return false;
			}
				
		
		
		
		public  boolean isElementNotPresent (By locator ){
			 if( getElementsCount (locator) == 0) {
				 return true;
			 }
			return false;
			
			
		}
		
	  public  boolean isElementPresentMultipleTimes (By locator ) {
		  if (getElementsCount (locator) >=1) {
			  return true;
			  
		  }
		   return false;
		  
		 }
	  
	  public boolean isElementDisplayed	(By locator) {
		  return getElement(locator).isDisplayed() ;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		
	  public String waitForTitleContainsAndReturn(String fractionTitle, int timeOut) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		   wait.until(ExpectedConditions.titleContains(fractionTitle));
		   return driver.getTitle();
}
		
	  
	  public String waitForURLContainsAndReturn(String fractionURL, int timeOut) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		   wait.until(ExpectedConditions.urlContains(fractionURL));
		   return driver.getCurrentUrl();
		   
}
	  
	  public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		  return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	  }
	  
	 
	  
	  public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		  return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	  }
	  
	  public WebElement waitforVisibilityOfElement(By locator, int timeOut) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		  return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	  }
	  
	  
	  public WebElement waitForElementVisible(By locator, int timeOut) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		  return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	  }
	  
		
	  public WebElement waitForElementVisible(By locator, int timeOut, int intervalTIme) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTIme) );
		  return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	  }
	  
	  public void waitForElementAndClikc(By locator, int timeOut) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		   wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	  }
	  
	  
		public boolean doSearch (By SearchField, By suggestions, String searchKey, String matchValue) throws InterruptedException, FrameworkException {
			
			boolean flag = false;
			
			 doSendKeys (SearchField, searchKey);
			// Thread.sleep(3000);
			
	
			 List<WebElement> suggestionList =	 getElements (suggestions); 
			 int totalSuggestions = suggestionList.size();
			 System.out.println("Total number of suggestions..===" +totalSuggestions );
			 if (totalSuggestions ==0  ) {
				 
				 System.out.println("No suggestions found....");
				 throw new FrameworkException ();
				 
    }
			 
			 for (WebElement e : suggestionList ) {
				String text= e.getText();		 
				System.out.println(text);
				if(text.contains(matchValue)) {
					e.click() ;
					flag = true ;
					break;
				}
		}
		  
			 if(flag ) {
				 System.out.println(matchValue + "is found");
				 return true ;
				 
				 
			 }
			 
			 else {
				 System.out.println(matchValue + "is not found");
			 }
			return false;
		}
		


//**************************** SELECT DROPDOWN UTILS********************************//
		
		
 //******* utilities for create object of Select************
  private Select getSelect (By locator ) {
	 return new Select (getElement(locator)) ;
	  
  }
		
		
public  int getDropDownOptionsCount (By locator ) {
     return getSelect(locator).getOptions().size();
	   
}
	

	
	public  void selectDropdownValueByVisibleText (By locator, String visibleText ) {
		getSelect(locator).selectByVisibleText(visibleText);
				
	}
	
	
	public  void selectDropdownValueBuyIndex (By locator, int index ) {
		getSelect(locator).selectByIndex(index);
				
	}
	
	
	
	public  void selectDropdownValueByValue (By locator, String value ) {
		getSelect(locator).selectByValue(value);
				
	}
	
	public List<String> getDropDownOptionsTextList (By locator )  {
      List<WebElement> optionsList =  getSelect(locator).getOptions();
        System.out.println(optionsList.size());
        List<String> optionsTextList = new ArrayList<String> ();
        
        for(WebElement e : optionsList) {
        String text =	e.getText();	
        optionsTextList.add(text);
        
    }
		return optionsTextList;
	}
		        
/**
 * 
 * @param locator
 * @param value
 */
 public void selectDropDownValue (By locator, String value ) {
		 
		 List<WebElement>  optionsList = getElements(locator) ;
			System.out.println(optionsList.size());
			
			for ( WebElement e : optionsList) {
				 String text = e.getText();
				 System.out.println(text);
				 if( text.contains(value)) {
					 e.click ();
					 driver.quit();
					 break;
					
					 
				 }
			}
	 }


	
	

	
	}






