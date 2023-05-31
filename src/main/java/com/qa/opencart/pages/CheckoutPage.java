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

	private By billingAddressContinueBtn = By.id("button-payment-address");
	private By deliveryAddressContinueBtn = By.id("button-shipping-address");
	private By deliveryMethodContinueBtn = By.id("button-shipping-method");
	private By agreementCheckbox = By.xpath("//input[@name='agree']");
	private By paymentMethodContinueBtn = By.id("button-payment-method");
	private By confirmOrderContinueBtn = By.id("button-confirm");
	private By addNewAddressRadioBtn = By.xpath("//input[@name='payment_address' and @value='new']");

	public void placeOrderWithPrefilledData() {
		elementUtil.doClick(billingAddressContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(deliveryAddressContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(deliveryMethodContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(agreementCheckbox, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(paymentMethodContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		// elementUtil.doClick(confirmOrderContinueBtn,
		// AppConstants.MEDIUM_DEFAULT_WAIT);

	}

	public void placeOrderWithoutPrefilledData() {
		elementUtil.doClick(By.xpath("//a[@href='#collapse-payment-address']"), AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(addNewAddressRadioBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		fillForm();
		elementUtil.doClick(billingAddressContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(deliveryAddressContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(deliveryMethodContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(agreementCheckbox, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(paymentMethodContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT);
		// elementUtil.doClick(confirmOrderContinueBtn,
		// AppConstants.MEDIUM_DEFAULT_WAIT);

	}

	private void fillForm() {
		elementUtil.doSendKeys(By.id("input-payment-firstname"), "Avinash");
		elementUtil.doSendKeys(By.id("input-payment-lastname"), "Reddy");
		elementUtil.doSendKeys(By.id("input-payment-company"), "nagarro");
		elementUtil.doSendKeys(By.id("input-payment-address-1"), "1564 seven pines road");
		elementUtil.doSendKeys(By.id("input-payment-city"), "Springfield");
		elementUtil.doSendKeys(By.id("input-payment-postcode"), "62704");
		elementUtil.doSelectDropDownByVisibleText(By.id("input-payment-country"), "United States");
		elementUtil.waitForElementPresence(By.xpath("//select[@id='input-payment-zone']/option[text()='Illinois']"),
				AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doSelectDropDownByVisibleText(By.id("input-payment-zone"), "Illinois");

	}

}
