Feature: Validate the Auto trader home page and validate the search results for BMW cars

  @test
  Scenario Outline: Validate whether user is able to see the "<Make>" car results
    Given user is on autotrader home page
    When user validates Browser by Make, Browse by Style and Advanced Search Links are present
    And user validates search button is present
    And user validates Make and model drop downs are present
    When user clicks on Advanced Search link
    And user enters "<Zip code>" in the text box
    And user selects certified checkbox under Condition
    And user selects convertible checkbox under Style
    And user selects "<From year>" and "<To year>" under year dropdowns
    And user selects "<Make>" under Make, Model and Trim section
    When user clicks on search button
    Then user sees results of the "<Make>" cars

    Examples: 
      | Zip code | From year | To year | Make |
      |    30004 |      2017 |    2020 | BMW  |
