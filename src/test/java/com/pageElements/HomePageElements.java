package com.pageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {

	public HomePageElements(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	public static String setLocator(String param) {
		String test = "//*[text()=\""+param+"\"]";
		return test;
	}

	public @FindBy(xpath = "//*[text()='Browse by Make']") WebElement browseByMake;
	public @FindBy(xpath = "//*[text()='Browse by Style']") WebElement browseByStyle;
	public @FindBy(linkText = "Advanced Search") WebElement advancedSearch;
	public @FindBy(id = "search") WebElement search;
	public @FindBy(id = "makeCodeListPlaceHolder") WebElement make;
	public @FindBy(id = "modelCodeListPlaceHolder") WebElement model;
	public @FindBy(id = "zipundefined") WebElement zipCode;
	public @FindBy(xpath = "//*[text()= 'Certified']") WebElement cerfied;
	public @FindBy(xpath = "//*[text()= 'Convertible']") WebElement convertible; 
	public @FindBy(id = "4101482096") WebElement fromYear;
	public @FindBy(id = "258002540") WebElement toYear;
	public @FindBy(id = "1970425032") WebElement makeDropdown;
	public @FindBy(xpath = "//button[@type='submit']") WebElement searchButton;
	public @FindBy(xpath = "//h2[@data-cmp='subheading']") List<WebElement> searchResults;
	
	

}
