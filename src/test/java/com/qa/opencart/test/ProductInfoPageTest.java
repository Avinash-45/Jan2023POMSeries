package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
import com.qa.opencart.pojo.Product;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void productInfoTest(Product product) {

		resultsPage = accountsPage.doSearch(product.getSearchKey());
		productInfopage = resultsPage.selectProduct(product.getProductName());
		Map<String, String> productInfoMap = productInfopage.getProductInfo();
		softAssert.assertEquals(productInfoMap.get("Brand"), product.getBrand());
		softAssert.assertEquals(productInfoMap.get("Product Name"), product.getProductName());
		softAssert.assertEquals(productInfoMap.get("Product Price"), product.getProductPrice());
		softAssert.assertAll();

	}

	@Test
	public void addToCartTest() {
		resultsPage = accountsPage.doSearch("MacBook");
		productInfopage = resultsPage.selectProduct("MacBook Pro");
		productInfopage.enterQuantity();
		String actualMessage = productInfopage.selectAddToCart();
		Assert.assertEquals(actualMessage,
				"Success: You have added " + productInfopage.getProductHeaderName() + " to your shopping cart!");
		productInfopage.navigateToCartPage();

	}

}
