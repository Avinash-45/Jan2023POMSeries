package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1.constructor of the page class
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private By logout = By.linkText("Logout");
	private By myAccount = By.linkText("My Account");
	private By accHeaders = By.xpath("//div/h2");
	private By search = By.name("search");
	private By searchBtn = By.xpath("//div[@id='search']//button");

	public String getAccPageTitle() {
		return elementUtil.waitForTitleIsAndCapture(AppConstants.ACCOUNTS_PAGE_TITLE_VALUE,
				AppConstants.SHORT_DEFAULT_WAIT);
	}

	public boolean isLogoutLinkExist() {
		return elementUtil.checkElementIsDisplayed(logout);
	}

	public boolean isMyAccountLinkExist() {
		return elementUtil.checkElementIsDisplayed(myAccount);
	}

	public List<String> getAccountPageHeadersList() {
		List<WebElement> headers = elementUtil.waitForElementsVisible(accHeaders, AppConstants.SHORT_DEFAULT_WAIT);
		List<String> headersText = new ArrayList<>();
		for (WebElement e : headers) {
			headersText.add(e.getText());
		}
		return headersText;
	}

	public ResultsPage doSearch(String productName) {
		elementUtil.doClear(search);
		elementUtil.waitForElementVisible(search, AppConstants.SHORT_DEFAULT_WAIT).sendKeys(productName);
		elementUtil.doClick(searchBtn);
		return new ResultsPage(driver);
	}

}
