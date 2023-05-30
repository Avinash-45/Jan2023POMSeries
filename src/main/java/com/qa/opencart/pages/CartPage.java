package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class CartPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1.constructor of the page class
	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	private By updateCartBtn = By.xpath("//button[@class='btn btn-primary']");
	private By updateSuccessMsg = By.xpath("//div[contains(@class,'alert-success')]");
	private By shippingCharges = By.xpath("//a[text()='Estimate Shipping & Taxes ']");
	private By country = By.id("input-country");
	private By state = By.id("input-zone");
	private By postcode = By.id("input-postcode");
	private By quotesBtn = By.xpath("//button[text()='Get Quotes']");
	private By shippingChargesRadioBtn = By.xpath("//input[@name='shipping_method']");
	private By applyShippingBtn = By.xpath("//input[@id='button-shipping']");
	private By shippingAmount = By.xpath("//strong[text()='Flat Shipping Rate:']/parent::td/following-sibling::td");
	private By removeProductBtn = By.xpath("//button[@class='btn btn-danger']");
	private By emptyCartText = By.xpath("(//p[text()='Your shopping cart is empty!'])[2]");
	private By checkOutBtn = By.xpath("//div[@class='pull-right']/a");

	public String updateProductQuantityInCart() {
		elementUtil.doClick(updateCartBtn);
		String message = elementUtil.getElement(updateSuccessMsg, AppConstants.MEDIUM_DEFAULT_WAIT).getText();
		return message.substring(0, message.length() - 2);
	}

	public String applyShippingCharges() {
		elementUtil.doClick(shippingCharges, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doSelectDropDownByVisibleText(country, "India");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doSelectDropDownByVisibleText(state, "Andhra Pradesh");
		elementUtil.doSendKeys(postcode, "534320");
		elementUtil.doClick(quotesBtn);
		elementUtil.doClick(shippingChargesRadioBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(applyShippingBtn);
		return elementUtil.waitForElementVisible(shippingAmount, AppConstants.MEDIUM_DEFAULT_WAIT).getText();
	}

	public String removeProductFromCart() {
		elementUtil.doClick(removeProductBtn);

		return elementUtil.waitForElementVisible(emptyCartText, AppConstants.MEDIUM_DEFAULT_WAIT).getText();
	}

	public CheckoutPage navigateToCheckout() {

		elementUtil.doClick(checkOutBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		return new CheckoutPage(driver);
	}

}
