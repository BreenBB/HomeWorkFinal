Feature: Search scenarios
  As a user
  I want to test search functionality
  So that I can be sure that user doesn't have issues with search field

  Scenario: Search Teddy Bear and check search result
    Given User opens 'https://www.ebay.com/' page
    And User checks search field visibility
    And User enters 'Teddy Bear' in the search field
    When User clicks on search button
    Then User checks what result contains 'Teddy Bear'

  Scenario: Negative scenario: Try search non existent item and check the "No exact matches found" message
    Given User opens 'https://www.ebay.com/' page
    And User checks search field visibility
    And User enters 'a totally non existent item' in the search field
    When User clicks on search button
    Then User checks the not found message

  Scenario: Negative scenario: Try entering in search field special symbols and check how search handles them
    Given User opens 'https://www.ebay.com/' page
    And User checks search field visibility
    And User enters '!@#$%^&*()_+|\[]{};:,./<>?' in the search field
    When User clicks on search button
    Then User checks that result is all categories page instead of search page