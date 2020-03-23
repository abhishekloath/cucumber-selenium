package com.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static WebDriver driver;

	public static void driverSetup() {
		if (driver == null) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-automation", "--disable-popup-blocking", "--allow-running-insecure-content",
					"--ignore-certificate-errors");
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	}

	public static WebDriver getDriverInstance() {
		return driver;
	}

	public static void quitDriver() {

		driver.quit();
	}
}
