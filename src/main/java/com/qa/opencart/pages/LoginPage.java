package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Description;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1.constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 2.Create private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");
	private By megaMenuLinks = By.xpath("//ul[@class='nav navbar-nav']/li");
	private By register_link = By.xpath("(//a[text()='Register'])[2]");
	private By desktop_link = By.xpath("//a[text()='Desktops']");
	private By showAllDesktopslink = By.xpath("//a[text()='Show All Desktops']");

	// 3. public page actions or page methods (Public)
	@Description(value = "This is the return method for login page title")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIsAndCapture(AppConstants.LOGIN_PAGE_TITLE_VALUE,
				AppConstants.SHORT_DEFAULT_WAIT);
	}

	public String getLoginPageURL() {
		return elementUtil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE,
				AppConstants.SHORT_DEFAULT_WAIT);
	}

	public boolean isForgotPwdLinkExist() {
		return elementUtil.checkElementIsDisplayed(forgotPwdLink);
	}

	public List<String> getFooterElementsList() {
		List<WebElement> footerLinksList = elementUtil.waitForElementsVisible(footerLinks,
				AppConstants.SHORT_DEFAULT_WAIT);
		List<String> footerTextsList = new ArrayList<String>();
		for (WebElement e : footerLinksList) {
			footerTextsList.add(e.getText());
		}
		return footerTextsList;
	}

	public AccountsPage doLogin(String userName, String pwd) {
		elementUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(userName);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		// return next landing page (page chaining model)
		return new AccountsPage(driver);
	}

	public boolean doLoginWithWrongCredentials(String userName, String pwd) {
		elementUtil.doClear(emailId);
		elementUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(userName);
		elementUtil.doClear(password);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		By loginErrorMessage = By.xpath("//div[contains(@class,'alert-danger')]");
		String text = elementUtil.doGetElementText(loginErrorMessage);
		if (text.contains(AppConstants.LOGIN_PAGE_INVALID_CREDENTIALS_ERROR_MESSAGE)
				|| text.contains(AppConstants.LOGIN_PAGE_INVALID_CREDENTIALS_ERROR_MESSAGE_2)) {
			return true;

		}
		return false;

	}

	public List<String> megaMenuLinksList() {
		List<WebElement> megaMenuLinksList = elementUtil.waitForElementsVisible(megaMenuLinks,
				AppConstants.SHORT_DEFAULT_WAIT);
		List<String> megaMenuTextsList = new ArrayList<String>();
		for (WebElement e : megaMenuLinksList) {
			megaMenuTextsList.add(e.getText());
		}
		return megaMenuTextsList;
	}

	public RegisterPage navigateToRegisterPage() {
		elementUtil.doClick(register_link, 10);
		return new RegisterPage(driver);
	}

	public ProductListingPage navigateToPLP() {
		elementUtil.doClick(desktop_link, AppConstants.MEDIUM_DEFAULT_WAIT);
		elementUtil.doClick(showAllDesktopslink, AppConstants.MEDIUM_DEFAULT_WAIT);
		return new ProductListingPage(driver);

	}

}
