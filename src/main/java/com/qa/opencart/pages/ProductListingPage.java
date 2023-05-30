package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductListingPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1.constructor of the page class
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	By sortLocator = By.id("input-sort");
	By productList=By.xpath("//h4/a");
	public String getSortedElementListByPriceLowAndHigh() {
		elementUtil.doSelectDropDownByIndex(sortLocator, 3);
		List<WebElement> productsListLowFirst = elementUtil.getElements(By.xpath("//div[@class='caption']//a"));
		String text=productsListLowFirst.get(0).getText();
		elementUtil.doSelectDropDownByIndex(sortLocator, 4);
		List<WebElement> productsListHighFirst = elementUtil.getElements(By.xpath("//div[@class='caption']//a"));
		return text + " " + productsListHighFirst.get(0).getText();
	}
	
	public int totalProductCount() {
		return elementUtil.getElements(productList).size();
		
	}

}
