Feature: Login Test

  Background:
    Given The user navigates to website

  Scenario: Positive Login Test 1 without parameter
    # Given The user navigates to website
    When The user clicks on login button and enters valid credentials
    Then The user verifies that welcome message is displayed


  Scenario: Positive Login Test 2 with parameter
    #Given The user navigates to website
    When The user clicks on login button and enters "SoftwareSoftware" and "qwerty.123"
    Then The user verifies that welcome "SoftwareSoftware" is displayed


  Scenario Outline: Positive Login Test 3 with scenario outline
    When The user clicks on login button and enters "<username>" and "<password>"
    Then The user verifies that welcome "<username>" is displayed
    Examples:
      | username         | password   |
      | SoftwareSoftware | qwerty.123 |