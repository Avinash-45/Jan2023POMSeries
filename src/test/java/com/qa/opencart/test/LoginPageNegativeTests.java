package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class LoginPageNegativeTests extends BaseTest {

	@DataProvider
	public Object[][] getIncorrectUserNamePasswordData() {
		return new Object[][] { { "avi@avi.com", "facebook@9" }, { "bavi@vaj.com", "Selenium@12345" },
				{ "janautomation@gmail.com", "Facebook@9" }, { " ", " " } };

	}

	@DataProvider
	public Object[][] getIncorrectUserNamePasswordDataFromExcel() {
		return ExcelUtil.getTestData(AppConstants.LOGIN_SHEET_NAME);

	}

	@Test(dataProvider = "getIncorrectUserNamePasswordDataFromExcel")
	public void userNotAbleToLoginTest(String username, String password) {
		boolean message = loginPage.doLoginWithWrongCredentials(username, password);
		Assert.assertTrue(message);

	}

}
