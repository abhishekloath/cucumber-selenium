package com.common;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.Scenario;

public class Util extends Driver {

	Properties properties = new Properties();
	public HashMap<String, String> configProperties = new HashMap<String, String>();

	public Util() {
		this.createMapFromProperties();
		this.browserType();
	}

	public void takeScreenShot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenShot, "image/png", "");
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public void createMapFromProperties() {
		try {
			properties.load(new FileInputStream("src/test/resources/Test.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String key : properties.stringPropertyNames()) {
			configProperties.put(key, properties.getProperty(key));
		}
	}

	public String browserType() {
		String browserName;

		if (System.getenv("Browser") == null) {
			browserName = configProperties.get("BROWSER");
			return browserName;
		} else {
			browserName = System.getenv("Browser");
			return browserName;
		}

	}

}
