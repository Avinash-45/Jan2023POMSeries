package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	public static final String LOGIN_PAGE_TITLE_VALUE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE_VALUE = "My Account";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "route=account/login";
	public static final int SHORT_DEFAULT_WAIT = 5;
	public static final int MEDIUM_DEFAULT_WAIT = 10;
	public static final int LONG_DEFAULT_WAIT = 20;
	public static final List<String> EXP_HEADERS_LIST_VALUES = Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletter");
	public static final String LOGIN_PAGE_INVALID_CREDENTIALS_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
	public static final String LOGIN_PAGE_INVALID_CREDENTIALS_ERROR_MESSAGE_2 = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";
	public static final String LOGIN_SHEET_NAME = "login";
	public static final String CART_QUANTITY_UPDATE_SUCCESS_MESSAGE = "Success: You have modified your shopping cart!";
	public static final String CART_EMPTY_MESSAGE = "Your shopping cart is empty!";
	public static final String FLAT_SHIPPING_RATE_INDIA = "$5.00";
	public static final String WISHLIST_PAGE_TITLE = "My Wish List";
	public static final String COMPARE_PRODUCT_SUCCESS_TEXT = "Success: You have added Apple Cinema 30\" to your product comparison!";
}
