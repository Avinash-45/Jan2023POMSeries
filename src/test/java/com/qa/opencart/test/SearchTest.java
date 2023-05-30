package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class SearchTest extends BaseTest {

	@BeforeClass
	public void searchSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getProductNameData() {
		return new Object[][] { { "Macbook" }, { "iMac" }, { "Samsung" } };

	}

	@Test(dataProvider = "getProductNameData")
	public void searchProductTest(String productName) {
		resultsPage = accountsPage.doSearch(productName);
		Assert.assertTrue(resultsPage.getProductResultsCount() > 0);
	}

	@Test(dataProvider = "getProductNameData")
	public void searchPageTitleTest(String productName) {
		resultsPage = accountsPage.doSearch(productName);
		String actTitle = resultsPage.getResultsPageTitle(productName);
		Assert.assertEquals(actTitle, "Search - " + productName);
	}

	@DataProvider
	public Object[][] getProductToChose() {
		return new Object[][] { { "Macbook", "MacBook Pro" }, { "iMac", "iMac" },
				{ "Samsung", "Samsung Galaxy Tab 10.1" } };

	}

	@Test(dataProvider = "getProductToChose")
	public void selectProductTest(String productName, String productToSelect) {
		resultsPage = accountsPage.doSearch(productName);
		productInfopage = resultsPage.selectProduct(productToSelect);
		Assert.assertEquals(productInfopage.getProductHeaderName(), productToSelect);

	}

	@DataProvider
	public Object[][] getProductForImage() {
		return new Object[][] { { "Macbook", "MacBook Pro", 4 }, { "iMac", "iMac", 3 },
				{ "Samsung", "Samsung Galaxy Tab 10.1", 7 } };

	}

	@Test(dataProvider = "getProductForImage")
	public void imagesCountTest(String productName, String productToSelect, int imageCount) {
		resultsPage = accountsPage.doSearch(productName);
		productInfopage = resultsPage.selectProduct(productToSelect);
		Assert.assertEquals(productInfopage.getProductImagesCount(), imageCount);

	}

	@Test(dataProvider = "getProductToChose")
	public void addProductToWishListFromSearchTest(String productName, String productToSelect) {
		resultsPage = accountsPage.doSearch(productName);
		wishListPage = resultsPage.addProductToWishList(productToSelect);
		Assert.assertEquals(wishListPage.getWishListPageTitle(), AppConstants.WISHLIST_PAGE_TITLE);
		wishListPage.deleteProductFromWishList();

	}
}
