package com.qa.opencart.test;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accountsPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}

	@Test
	public void isLogOutLinkDisplayedTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}

	@Test
	public void isMyAccountLinkDisplayedTest() {
		Assert.assertTrue(accountsPage.isMyAccountLinkExist());
	}

	@Test
	public void myAccountHeadersCountTest() {
		Assert.assertEquals(accountsPage.getAccountPageHeadersList().size(), 4);
	}

	@Test
	public void myAccountHeadersTest() {
		List<String> actHeadersList = accountsPage.getAccountPageHeadersList();
		Collections.sort(actHeadersList);
		Collections.sort(AppConstants.EXP_HEADERS_LIST_VALUES);
		Assert.assertEquals(actHeadersList, AppConstants.EXP_HEADERS_LIST_VALUES);
	}

}
