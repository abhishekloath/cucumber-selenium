package com.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.Scenario;

public class Util extends Driver {

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
}
