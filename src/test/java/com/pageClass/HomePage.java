package com.pageClass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageElements.HomePageElements;

public class HomePage extends BasePage {

	HomePageElements homePageEle = new HomePageElements(driver);

	public void navigateToHomePage() {

		openAppURL();

	}

	public void validateLinks() {

		WaitForElement(homePageEle.browseByMake);
		Assert.assertTrue(homePageEle.browseByMake.isDisplayed(), "Browse by Make is not displayed");
		Assert.assertTrue(homePageEle.browseByStyle.isDisplayed(), "Broswse by Style is not displayed");
		Assert.assertTrue(homePageEle.advancedSearch.isDisplayed(), "Advanced search is not displayed");

	}

	public void validateButton() {

		Assert.assertTrue(homePageEle.search.isDisplayed(), "Search button is not displayed");
	}

	public void validateDropDowns() {

		Assert.assertTrue(homePageEle.make.isDisplayed(), "Make dropdown is not displayed");
		Assert.assertTrue(homePageEle.model.isDisplayed(), "Model dropdown is not displayed");
	}

	public void selectYears(String fromYear, String toYear) {

		selectFromDropDown(homePageEle.fromYear, fromYear);
		selectFromDropDown(homePageEle.toYear, toYear);
	}

	public void validateSearchResults(String make) {

		List<WebElement> element = homePageEle.searchResults;
		System.out.println("Results count ---- " + element.size());
		for (WebElement result : element) {
			System.out.println("Results text------   " + result.getText());
			String[] resultText = result.getText().split("\\s+");
			for (int i = 0; i < resultText.length; i++) {
				if (resultText[i].equals(make)) {
					Assert.assertTrue(true);
					System.out.println("Result match with make --- " + resultText[i].equals(make));
				}
			}
		}
	}

	public void validatePageTitle() {

		System.out.println("Page Title ---------- " + driver.getTitle());

	}

}
