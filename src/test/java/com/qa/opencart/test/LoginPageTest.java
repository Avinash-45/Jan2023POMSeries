package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;

@Epic(value = "Open Cart Application Login Page Scenarios")
@Stories(value = { @Story(value = "Login Title Test"), @Story(value = "Login URL Test"),
		@Story(value = "Forgot Password Link Test"), @Story(value = "Footer Links Test"),
		@Story(value = "Mega Menu Links Test"), @Story(value = "Positive Login Test") })
public class LoginPageTest extends BaseTest {

	@Story(value = "Login Page Title Scenario")
	@Severity(value = SeverityLevel.TRIVIAL)
	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);

	}

	@Story(value = "Login Page URL Scenario")
	@Severity(value = SeverityLevel.CRITICAL)
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));

	}

	@Story(value = "Forgot password Scenario")
	@Severity(value = SeverityLevel.MINOR)
	@Test
	public void forgotPasswordLinkExistsTest() {
		boolean actualValue = loginPage.isForgotPwdLinkExist();
		Assert.assertTrue(actualValue);

	}

	@Story(value = "Footer Links Scenario")
	@Severity(value = SeverityLevel.NORMAL)
	@Test
	public void totalNumberOfFooterLinks() {
		int footersLinksize = loginPage.getFooterElementsList().size();
		Assert.assertEquals(footersLinksize, 16);
	}

	@Story(value = "Mega Menu Links Scenario")
	@Severity(value = SeverityLevel.CRITICAL)
	@Test
	public void megaMenuLinksTest() {
		Assert.assertTrue(loginPage.megaMenuLinksList().contains("Software"));
	}

	@Story(value = "Positive Login Scenario")
	@Severity(value = SeverityLevel.BLOCKER)
	@Test
	public void userAbleToLoginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String actTitle = accountsPage.getAccPageTitle();
		Assert.assertEquals(actTitle, "My Account");
	}

}
