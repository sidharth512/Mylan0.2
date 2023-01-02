Feature: Add new Customer
  Background:
    Given  User Launch Chrome Browser
    When User Opens the URL "https://admin-demo.nopcommerce.com/login"
    And Enter the Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then User can view Dashboad
@smoke
  Scenario: Adding of new Customer
    When User click on Customers menu
    And click on customer menu tab
    And click on Add new button
    Then User can view Add new customer page
    When user give the customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully"


@sanity
Scenario: Search Custmor by EmailID

  When User click on Customers menu
  And click on customer menu tab
  And Enter customer EmailID
  When click on Search Button
  Then User should found Email in the search table

@sanity
  Scenario: Search Customer By FirstName And LastName
    When User click on Customers menu
    And click on customer menu tab
    And Enter Customer FirstName
    And Enter Customer LastName
    When click on Search Button
    Then User should found FirstName and LastName in the search table


