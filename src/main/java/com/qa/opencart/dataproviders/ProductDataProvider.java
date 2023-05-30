package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.Product;

public class ProductDataProvider {

	@DataProvider(name = "productData")
	public Object[][] getProductTestData() {
		return new Object[][] { { new Product("Macbook", "MacBook Pro", 4, "$2,000.00", "Apple") },
				{ new Product("iMac", "iMac", 3, "$100.00", "Apple") },
				{ new Product("Samsung", "Samsung Galaxy Tab 10.1", 7, "$199.99", null) } };

	}

}
