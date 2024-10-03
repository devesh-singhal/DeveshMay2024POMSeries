package com.qa.opencart.tests;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebElement;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetup()  {
		
		try {
			accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void AcocuntsPageTitleTest() {
		String actualTitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());

	}

	@Test
	public void accountsPageHeadersCountTest() {
		Assert.assertEquals(accPage.getTotalAccountsPageHeader(), 4);

		// Assert.assertEquals

	}

//	
	@Test
	public void accountsPageHeadersTest() {
		List<String> actualListOfHeaders = accPage.getAccountPageHeaders();
		Assert.assertEquals(actualListOfHeaders, AppConstants.EXPECTED_ACCOUNTSPAGE_HEADERS_LIST);
	}

	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] { { "macbook", 3 }, { "imac", 1 }, { "samsung", 2 } };

	}

	@Test(dataProvider = "getSearchKey")
	public void searchCountTest(String searchKey, int searchCount) throws InterruptedException {

		resultsPage = accPage.doSearch(searchKey);
		Assert.assertEquals(resultsPage.getSearchResultsCount(), searchCount);
	}

	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] { { "macbook", "MacBook Pro" }, { "macbook", "MacBook" }, { "imac", "iMac" },
				{ "samsung", "Samsung SyncMaster 941BW" }, { "samsung", "Samsung Galaxy Tab 10.1" } };

	}

	@Test(dataProvider = "getSearchData")
	public void searchTest(String searchKey, String productName) throws InterruptedException {

		resultsPage = accPage.doSearch(searchKey);
		productInfoPage = resultsPage.selectProdcut(productName);
		Assert.assertEquals(productInfoPage.getProductHeader(), productName);

	}

}
