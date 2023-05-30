package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productResults = By.xpath("//div[contains(@class,'product-grid')]");

	private By topWishListLink = By.xpath("//a[@id='wishlist-total']");

	// 1.constructor of the page class
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getResultsPageTitle(String searchKey) {
		return elementUtil.waitForTitleIsAndCapture(searchKey, 5);
	}

	public int getProductResultsCount() {
		return elementUtil.waitForElementsVisible(productResults, 10).size();
	}

	public ProductInfopage selectProduct(String productName) {
		// dynamic locator
		elementUtil.clickElementWhenReady(By.linkText(productName), 5);
		return new ProductInfopage(driver);

	}

	public WishListPage addProductToWishList(String productToSelect) {
		By addToWishList = By
				.xpath("//a[text()='" + productToSelect + "']/parent::h4/parent::div/following-sibling::div/button[2]");
		elementUtil.doClick(addToWishList, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(topWishListLink, AppConstants.SHORT_DEFAULT_WAIT);
		return new WishListPage(driver);
	}

}
