package com.pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.common.Driver;
import com.common.Util;

public class BasePage extends Util {

	public WebDriver driver;

	public BasePage() {
		this.driver = Driver.getDriverInstance();
	}

	public void openAppURL() {
		System.out.println("Application URL --- " + configProperties.get("APPURL"));
		driver.get(configProperties.get("APPURL"));

	}

	public void clickElement(WebElement element) {

		try {
			deleteCookies();
			element.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void WaitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickCheckbox(WebElement element) {
		if (!element.isSelected())
			try {
				element.click();
			} catch (Exception e) {
				System.out.println(e);
			}

	}

	public void selectFromDropDown(WebElement element, String text) {

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);

	}

	public void deleteCookies() {

		driver.manage().deleteAllCookies();
	}

}
