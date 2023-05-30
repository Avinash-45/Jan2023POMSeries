package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class WishListPageTest extends BaseTest {
	@BeforeClass
	public void accountPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void addToCartFromWishListTest() {
		resultsPage = accountsPage.doSearch("Macbook");
		wishListPage = resultsPage.addProductToWishList("MacBook Pro");
		Assert.assertTrue(wishListPage.addToCartFromWishList());
	}

}
