package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.ProductInfoPage;

public class ProductInfoPageTest extends BaseTest{
	
	private ProductInfoPage prodcutInfoPage;

	@BeforeClass
	public void  productInfoSetUp () throws InterruptedException {
	   accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password")) ;
	   
		
	}
	
	@DataProvider
	public Object[][] getProductHeaderData() {
		return new Object [] []  {
			{"macbook" , "MacBook Pro"},
			{"macbook" , "MacBook"},
			{"samsung" , "Samsung SyncMaster 941BW"},
			
		};
		
	}
	
	@Test (dataProvider = "getProductHeaderData")
	public void productHeaderTest(String searchKey, String headerName) throws InterruptedException {
	resultsPage =	accPage.doSearch(searchKey) ;
	productInfoPage = resultsPage.selectProdcut(headerName) ;
	Assert.assertEquals(productInfoPage.getProductHeader(), headerName) ;
	
	
	
	
	}
	
	
	
	@Test
	public void productInfoTest() throws InterruptedException {
		resultsPage =	accPage.doSearch("macbook") ;
		productInfoPage = resultsPage.selectProdcut("MacBook Pro") ;
		Map <String, String> actualProductDataMap = productInfoPage.getProductData() ;
		softAssert.assertEquals(actualProductDataMap.get("Brand"), "Apple");
		softAssert.assertEquals(actualProductDataMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actualProductDataMap.get("Reward Points"), "800");
		softAssert.assertEquals(actualProductDataMap.get("Availability"), "In Stock");
		softAssert.assertEquals(actualProductDataMap.get("productprice"), "$2,000.00");
		softAssert	.assertEquals(actualProductDataMap.get("extaxprice"), "$2,000.00");
		softAssert.assertAll();
		
		
	}
	
	
	@DataProvider
	public Object[][] getProductImagesCountData() {
		return new Object [] []  {
			{"macbook" , "MacBook Pro" , 4  },
			{"imac" , "iMac" , 3  },
			{"samsung" , "Samsung SyncMaster 941BW" , 1  },
			{"samsung" , "Samsung Galaxy Tab 10.1" , 7  },
			{"canon" , "Canon EOS 5D" , 3 },
			
			
		} ;
	}
	
	
	
	 
	@Test (dataProvider = "getProductImagesCountData")
	public void productImagesCountTest(String searchKey, String productName, int imagesCount) throws InterruptedException {
		resultsPage =	accPage.doSearch(searchKey) ;
		productInfoPage = resultsPage.selectProdcut(productName) ;
		Assert.assertEquals (productInfoPage.getProductImagesCount() , imagesCount );
		
		 
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
