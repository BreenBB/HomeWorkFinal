Feature: Product Catalog sorting
  As a user
  I want to test various sorting functionality
  So that I can be sure that user can sort products as desired

  Scenario: Check graphic card catalog sorting by minimum and maximum price
    Given User opens 'https://www.ebay.com/' page
    And User checks Electronics tab visibility
    When User clicks on Electonics Tab
    And User checks Computers Catalog visibility
    And User clicks on Computers Catalog Tab
    When User checks Computer Components DropDown list
    And User clicks on Components DropDown list
    And User checks Graphics Cards visibility
    And User clicks on Graphics Cards Tab
    And User sets minimum price 50 and maximum 75 and press Enter
    Then User checks what prices off all goods are within selected range of 50 and 75

  Scenario: Check graphic card catalog filtering by tags
    Given User opens 'https://www.ebay.com/' page
    And User checks Electronics tab visibility
    When User clicks on Electonics Tab
    And User checks Computers Catalog visibility
    And User clicks on Computers Catalog Tab
    When User checks Computer Components DropDown list
    And User clicks on Components DropDown list
    And User checks Graphics Cards visibility
    And User clicks on Graphics Cards Tab
    And User sets 'AMD' filter tag
    And User sets '4 GB' filter tag
    Then User checks what filtering result is 'AMD-4-GB-Memory'

  Scenario: Negative scenario: Check what catalog sorting in descension order is bugged
    Given User opens 'https://www.ebay.com/' page
    And User checks Electronics tab visibility
    When User clicks on Electonics Tab
    And User checks Computers Catalog visibility
    And User clicks on Computers Catalog Tab
    When User checks Computer Components DropDown list
    And User clicks on Components DropDown list
    And User checks Graphics Cards visibility
    And User clicks on Graphics Cards Tab
    And User clicks on sorting selection list
    And User selects sorting from highest price
    Then User checks what items are sorted in descension order incorrectly

  Scenario: Change item list view from grid to list
    Given User opens 'https://www.ebay.com/' page
    And User checks Electronics tab visibility
    When User clicks on Electonics Tab
    And User checks Computers Catalog visibility
    And User clicks on Computers Catalog Tab
    When User checks Computer Components DropDown list
    And User clicks on Components DropDown list
    And User checks Graphics Cards visibility
    And User clicks on Graphics Cards Tab
    And User hover mouse on view selection drop down
    And User selects view by list
    Then User checks what items sorted in vertical list instead of grid-like gallery view