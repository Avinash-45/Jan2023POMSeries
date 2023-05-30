package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class WishListPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1.constructor of the page class
	public WishListPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	private By addToCartBtn = By.xpath("//button[@data-original-title='Add to Cart']");
	private By deleteItemFromWishlistBtn = By.xpath("//a[@class='btn btn-danger']");

	public String getWishListPageTitle() {
		return elementUtil.waitForTitleIsAndCapture("Wish", AppConstants.MEDIUM_DEFAULT_WAIT);
	}

	public boolean addToCartFromWishList() {
		elementUtil.doClick(addToCartBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		By cartBtnBlock = By.xpath("//span[@id='cart-total']");
		if (elementUtil.getElement(cartBtnBlock,AppConstants.MEDIUM_DEFAULT_WAIT).getText().contains("item")) {
			return true;
		}
		return false;

	}

	public void deleteProductFromWishList() {
		elementUtil.doClick(deleteItemFromWishlistBtn, AppConstants.SHORT_DEFAULT_WAIT);

	}

}
