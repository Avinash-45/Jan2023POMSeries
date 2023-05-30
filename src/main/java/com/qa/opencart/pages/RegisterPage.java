package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1.constructor of the page class
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	private By first_name = By.id("input-firstname");
	private By last_name = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirm_password = By.id("input-confirm");
	private By privacy_policy = By.xpath("//input[@type='checkbox']");
	private By continue_btn = By.xpath("//input[@value='Continue']");
	private By register_Success = By.xpath("//div[@id='content']/h1");
	private By logout = By.xpath("(//a[text()='Logout'])[2]");

	public String doRegister(String firstname, String lastName, String email_id, String phoneNo, String pwd,
			String confirmPassword) {
		elementUtil.waitForElementVisible(first_name, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(firstname);
		elementUtil.doSendKeys(last_name, lastName);
		elementUtil.doSendKeys(email, email_id);
		elementUtil.doSendKeys(telephone, phoneNo);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doSendKeys(confirm_password, confirmPassword);
		elementUtil.doClick(privacy_policy);
		elementUtil.doClick(continue_btn);
		return elementUtil.waitForElementVisible(register_Success, AppConstants.MEDIUM_DEFAULT_WAIT).getText();
	}

	public void doLogout() {
		elementUtil.doClick(logout);
	}

}
