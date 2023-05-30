package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

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

}
