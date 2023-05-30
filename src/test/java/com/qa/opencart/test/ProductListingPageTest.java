package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class ProductListingPageTest extends BaseTest {

	@BeforeClass
	public void productListingPageSetup() {
		productListingPage = loginPage.navigateToPLP();
	}

	@Test
	public void priceLowAndHighSortTest() {
		String actualValue = productListingPage.getSortedElementListByPriceLowAndHigh();
		Assert.assertEquals(actualValue, "Canon EOS 5D Sony VAIO");

	}

	@Test
	public void totalProductCountInPLPTest() {
		int actualValue = productListingPage.totalProductCount();
		Assert.assertEquals(actualValue, 12);

	}

	@Test
	public void compareProductsTest() {
		String actualValue = productListingPage.compareProducts();
		Assert.assertEquals(actualValue, AppConstants.COMPARE_PRODUCT_SUCCESS_TEXT);

	}

}
