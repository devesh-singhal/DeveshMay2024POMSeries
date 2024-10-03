package com.qa.opencart.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver ()	;
		driver.get("https://github.com/SeleniumHQ");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		 String title = driver.getTitle();
		  System.out.println("Current page title is " + title);
		driver.navigate().to("https://www.rrbapply.gov.in/") ;
		 String titlerrb = driver.getTitle();
		  System.out.println("Current page title is " + titlerrb);
		driver.manage().window().minimize();
		//	driver.quit();
		
		

		
	}

}
