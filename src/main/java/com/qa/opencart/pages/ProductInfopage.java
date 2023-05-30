package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfopage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productHeader = By.xpath("//div/h1");
	private By productImages = By.xpath("//ul[@class='thumbnails']//img");
	private By productMetaData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][1]/li");
	private By productPriceData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][2]/li");
	private By quantityLocator = By.xpath("//input[@name='quantity']");
	private By addToCartBtn = By.xpath("//button[@id='button-cart']");
	private By successMessageLocator = By.xpath("//div[contains(@class,'alert-success')]");
	private By cartTotalLink = By.xpath("//span[@id='cart-total']");
	private By viewCartLink = By.xpath("(//a[contains(@href,\"route=checkout/cart\")])[2]");

	private Map<String, String> productInfoMap;

	// 1.constructor of the page class
	public ProductInfopage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getProductHeaderName() {
		return elementUtil.doGetElementText(productHeader);
	}

	public int getProductImagesCount() {
		return elementUtil.waitForElementsVisible(productImages, 10).size();
	}

	public Map<String, String> getProductInfo() {
		// productInfoMap = new HashMap<String, String>();
		// productInfoMap = new LinkedHashMap<String, String>();
		productInfoMap = new TreeMap<String, String>();
		getProductMetaData();

		getPricingData();

		productInfoMap.put("Product Name", getProductHeaderName());
		return productInfoMap;

	}

	private void getProductMetaData() {
		List<WebElement> metaList = elementUtil.waitForElementsVisible(productMetaData, 10);

		for (WebElement e : metaList) {
			String metaText = e.getText();
			String[] metaInfoArray = metaText.split(":");
			String key = metaInfoArray[0].trim();
			String value = metaInfoArray[1].trim();
			productInfoMap.put(key, value);
		}

	}

	private void getPricingData() {
		List<WebElement> priceList = elementUtil.waitForElementsVisible(productPriceData, 10);
		String priceValue = priceList.get(0).getText();
		String[] extTaxPrice = priceList.get(1).getText().split(":");
		String taxValue = extTaxPrice[1].trim();
		productInfoMap.put("Product Price", priceValue);
		productInfoMap.put("Tax Price", taxValue);

	}

	public void enterQuantity() {
		elementUtil.doSendKeys(quantityLocator, "2");
	}

	public String selectAddToCart() {
		elementUtil.doClick(addToCartBtn);
		String successMessage = elementUtil
				.waitForElementVisible(successMessageLocator, AppConstants.MEDIUM_DEFAULT_WAIT).getText();
		return successMessage.substring(0, 58);
	}

	public CartPage navigateToCartPage() {
		elementUtil.doClick(cartTotalLink, 5);
		elementUtil.doClick(viewCartLink);
		return new CartPage(driver);
	}

}
