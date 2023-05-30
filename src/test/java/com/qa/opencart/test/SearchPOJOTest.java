package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
import com.qa.opencart.pojo.Product;

public class SearchPOJOTest extends BaseTest {
	@BeforeClass
	public void searchSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void searchProductTest(Product product) {
		resultsPage = accountsPage.doSearch(product.getProductName());
		Assert.assertTrue(resultsPage.getProductResultsCount() > 0);
	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void searchPageTitleTest(Product product) {
		resultsPage = accountsPage.doSearch(product.getProductName());
		String actTitle = resultsPage.getResultsPageTitle(product.getProductName());
		Assert.assertEquals(actTitle, "Search - " + product.getProductName());
	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void selectProductTest(Product product) {
		resultsPage = accountsPage.doSearch(product.getSearchKey());
		productInfopage = resultsPage.selectProduct(product.getProductName());
		Assert.assertEquals(productInfopage.getProductHeaderName(), product.getProductName());

	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void imagesCountTest(Product product) {
		resultsPage = accountsPage.doSearch(product.getSearchKey());
		productInfopage = resultsPage.selectProduct(product.getProductName());
		Assert.assertEquals(productInfopage.getProductImagesCount(), product.getProductImages());

	}

}
