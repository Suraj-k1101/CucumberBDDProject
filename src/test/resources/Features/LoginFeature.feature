Feature: Login

  @Sanity
  Scenario: Successful Login with Valid Credential
    Given User Launch Chrome Browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User Enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And Close Browser
