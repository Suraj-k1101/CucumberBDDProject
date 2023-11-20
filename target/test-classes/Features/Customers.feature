Feature: Customers

  Background: Steps common for all scenarios
    Given User Launch Chrome Browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User Enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard

  @regression
  Scenario: Add New Customer
    When User click on Customers Menu
    And click on Customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
  
  @regression
  Scenario: Search Customer by Email
    When User click on Customers Menu
    And click on Customers Menu Item
    And click on customer Email
    When click on Search button
    Then User should found Email in the Search table
    And close browser

  @Sanity
  Scenario: Search Customer by Name
    When User click on Customers Menu
    And click on Customers Menu Item
    And Enter customer FisrtName
    And Enter customer LastName
    When click on Search button
    Then user should found Name in the Search table
    And close browser
