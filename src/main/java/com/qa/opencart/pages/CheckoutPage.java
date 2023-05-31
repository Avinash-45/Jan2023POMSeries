package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class CheckoutPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1.constructor of the page class
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	By billingAddressContinueBtn = By.id("button-payment-address");
	By deliveryAddressContinueBtn = By.id("button-shipping-address");
	By deliveryMethodContinueBtn = By.id("button-shipping-method");
	By agreementCheckbox = By.xpath("//input[@name='agree']");
	By paymentMethodContinueBtn = By.id("button-payment-method");
	By confirmOrderContinueBtn = By.id("button-confirm");

	public void placeOrderWithPrefilledData() {
		elementUtil.doClick(billingAddressContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(deliveryAddressContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(deliveryMethodContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(agreementCheckbox, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(paymentMethodContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(confirmOrderContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);

	}
	
	public void placeOrderWithoutPrefilledData() {
		
	}

}
