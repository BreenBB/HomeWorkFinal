Feature: Add to cart
  As a user
  I want to test cart
  So that I can be sure that user can add items to cart

  Scenario: Add and remove added item from cart
    Given User opens 'https://www.ebay.com/' page
    And User checks search field visibility
    And User enters 'ati radeon rx580' in the search field
    When User clicks on search button
    And User clicks on first found item in search menu
    And User adds item to cart
    And User removes item from cart
    Then User checks what item are removed from cart
