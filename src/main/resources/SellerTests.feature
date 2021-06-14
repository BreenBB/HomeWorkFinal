Feature: Seller tests
  As a user
  I want to test functionality of seller page

  Scenario: Go to item page and check seller rest of items for sale
    Given User opens 'https://www.ebay.com/' page
    And User checks search field visibility
    And User enters 'ati radeon rx580' in the search field
    When User clicks on search button
    And User clicks on first found item in search menu
    And User clicks on seller profile link
    And User clicks on seller item for sale link
    Then User checks what link have item list

  Scenario: Go to item page and check seller feedback page
    Given User opens 'https://www.ebay.com/' page
    And User checks search field visibility
    And User enters 'ati radeon rx580' in the search field
    When User clicks on search button
    And User clicks on first found item in search menu
    And User clicks on seller profile link
    And User clicks on seller feedback link
    Then User checks what feedback page is opened and have feedback ratings element