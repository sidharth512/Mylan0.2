Feature: login
Background:
  Given User Launch Chrome Browser
  When User opens URL "https://demo.actitime.com"
  @smoke
  Scenario: Successfull login with Valid Credentails

    And User enters Email as "admin" and Password as "manager"
    And Click on Login
    Then Page Title should be "actiTIME - Enter Time-Track"
    When click on log out Link
    Then Page Title should be "actiTIME - Login"


  Scenario Outline: Login Data Validation

      And User enters Email as "<email>" and Password as "<password>"
      And Click on Login
      Then Page Title should be "actiTIME -  Enter Time-Track"
      When click on log out Link
      Then Page Title should be "actiTIME - Login"


      Examples:
        |email|password|
      |tester|manager|
      |admin|tester|
      |admin|manager|


