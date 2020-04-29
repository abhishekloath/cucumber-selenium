package com.stepDefinitions;

import com.pageClass.BasePage;
import com.pageClass.HomePage;
import com.pageElements.HomePageElements;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends BasePage {

	HomePageElements homePageEle = new HomePageElements(driver);
	HomePage homePage = new HomePage();

	@Given("user is on autotrader home page")
	public void user_is_on_autotrader_home_page() {
		homePage.navigateToHomePage();
		homePage.validatePageTitle();

	}

	@When("user validates Browser by Make, Browse by Style and Advanced Search Links are present")
	public void user_validates_Browser_by_Make_Browse_by_Style_and_Advanced_Search_Links_are_present() {
		homePage.validateLinks();
	}

	@When("user validates search button is present")
	public void user_validates_search_button_is_present() {
		homePage.validateButton();
	}

	@When("user validates Make and model drop downs are present")
	public void user_validates_Make_and_model_drop_downs_are_present() {
		homePage.validateDropDowns();
	}

	@When("user clicks on Advanced Search link")
	public void user_clicks_on_Advanced_Search_link() {

		clickElement(homePageEle.advancedSearch);

	}

	@When("user enters {string} in the text box")
	public void user_enters_in_the_text_box(String zipCode) {
		WaitForElement(homePageEle.zipCode);
		enterText(homePageEle.zipCode, zipCode);
	}

	@When("user selects certified checkbox under Condition")
	public void user_selects_certified_checkbox_under_Condition() {
		clickCheckbox(homePageEle.certified);
	}

	@When("user selects convertible checkbox under Style")
	public void user_selects_convertible_checkbox_under_Style() throws InterruptedException {
		clickCheckbox(homePageEle.convertible);
	}

	@When("user selects {string} and {string} under year dropdowns")
	public void user_selects_and_under_year_dropdowns(String fromYear, String toYear) {
		homePage.selectYears(fromYear, toYear);

	}

	@When("user selects {string} under Make, Model and Trim section")
	public void user_selects_under_Make_Model_and_Trim_section(String make){
		selectFromDropDown(homePageEle.makeDropdown, make);
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		clickElement(homePageEle.searchButton);
	}

	@Then("user sees results of the {string} cars")
	public void user_sees_results_of_the_cars(String make) {
		homePage.validateSearchResults(make);
	}

}
