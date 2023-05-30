package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class CartPageTest extends BaseTest {
	@BeforeClass
	public void cartPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		resultsPage = accountsPage.doSearch("MacBook");
		productInfopage = resultsPage.selectProduct("MacBook Pro");
		productInfopage.selectAddToCart();
		cartPage = productInfopage.navigateToCartPage();
	}

	@Test(priority = 1)
	public void quantityUpdateTest() {

		String actualMessage = cartPage.updateProductQuantityInCart();
		Assert.assertEquals(actualMessage, AppConstants.CART_QUANTITY_UPDATE_SUCCESS_MESSAGE);
	}

	@Test(priority = 2)
	public void shippingChargesTest() {
		String actualShippingCost = cartPage.applyShippingCharges();
		Assert.assertEquals(actualShippingCost, AppConstants.FLAT_SHIPPING_RATE_INDIA);
	}

	@Test(priority = 3)
	public void deleteCartTest() {
		String actualMessage = cartPage.removeProductFromCart();
		
		
		Assert.assertEquals(actualMessage, AppConstants.CART_EMPTY_MESSAGE);
	}

}
