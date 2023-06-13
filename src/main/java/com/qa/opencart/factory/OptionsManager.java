package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if (prop.getProperty("headless").equals("true")) {
			co.addArguments("--headless");
		}
		if (prop.getProperty("incognito").equals("true")) {
			co.addArguments("--incognito");
		}
		if (prop.getProperty("remote").equals("true")) {
			co.setCapability("browserName", "chrome");
			co.setBrowserVersion(prop.getProperty("browserversion"));
		}
		return co;

	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if (prop.getProperty("headless").equals("true")) {
			fo.addArguments("--headless");
		}
		if (prop.getProperty("incognito").equals("true")) {
			fo.addArguments("--incognito");
		}
		if (prop.getProperty("remote").equals("true")) {
			fo.setCapability("browserName", "firefox");
			fo.setBrowserVersion(prop.getProperty("browserversion"));
		}
		return fo;

	}

	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if (prop.getProperty("headless").equals("true")) {
			eo.addArguments("--headless");
		}
		if (prop.getProperty("incognito").equals("true")) {
			eo.addArguments("--incognito");
		}
		if (prop.getProperty("remote").equals("true")) {
			eo.setCapability("browserName", "edge");
		}
		return eo;

	}

}
