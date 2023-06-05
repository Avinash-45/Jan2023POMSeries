package com.qa.opencart.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class CheckoutPageTest extends BaseTest {
	@BeforeClass(groups = "sanityTest")
	public void checkoutPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		resultsPage = accountsPage.doSearch("MacBook");
		productInfopage = resultsPage.selectProduct("MacBook Pro");
		productInfopage.selectAddToCart();
		cartPage = productInfopage.navigateToCartPage();
		checkoutPage = cartPage.navigateToCheckout();
	}

	@Test(groups = { "sanityTest" })
	public void placeOrderWithFilledDataTest() {
		checkoutPage.placeOrderWithPrefilledData();
	}

	@Test(groups = { "sanityTest" })
	public void placeOrderWithoutFilledDataTest() {
		checkoutPage.placeOrderWithoutPrefilledData();
	}

}
