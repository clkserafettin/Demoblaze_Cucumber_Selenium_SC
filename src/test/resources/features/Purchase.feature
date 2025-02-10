Feature: The user should be able to place order from website

  @wip
  Scenario: Placing a successful order - E2E Test
    Given The user navigates to website
    When The user clicks on login button and enters "SoftwareSoftware" and "qwerty.123"
    When The user adds "Samsung galaxy s7" product from "Phones" category
    When The user adds "Sony vaio i5" product from "Laptops" category
    When The user adds "MacBook Pro" product from "Laptops" category
    When The user adds "Apple monitor 24" product from "Monitors" category
    When The user removes "Sony vaio i5" from cart page
    When The user place order and capture log amount
    Then The user verifies purchase amount
