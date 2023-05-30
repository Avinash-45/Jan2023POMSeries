package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeMethod
	public void registerSetUp() {
		registerPage = loginPage.navigateToRegisterPage();
	}

	@DataProvider
	public Object[][] getUserData() {
		return new Object[][] {
				{ "test", "test", "testautomation" + System.currentTimeMillis() + "@sharklasers.com", "2345665677",
						"Facebook@9", "Facebook@9" },
				{ "Avi", "tester", "avitester" + System.currentTimeMillis() + "@sharklasers.com", "9085463545",
						"Facebook@9", "Facebook@9" } };

	}

	@DataProvider
	public Object[][] getUserDataFromExcel() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);

	}

	@Test(dataProvider = "getUserDataFromExcel")
	public void registerUsers(String firstName, String lastName, String telephone, String password,
			String confirmPassword) {

		String message = registerPage.doRegister(firstName, lastName, "testautomation" + System.currentTimeMillis() + "@sharklasers.com", telephone, password, confirmPassword);
		Assert.assertEquals(message, AppConstants.REGISTER_SUCCESS_MESSAGE);
		registerPage.doLogout();

	}

}
