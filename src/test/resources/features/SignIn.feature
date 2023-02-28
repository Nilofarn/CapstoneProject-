Feature: Retail Signin feature

  @Regresion @FunctionalTestCases
  Scenario: Verify user can sign in into Retail Application
    Given: User is on Retail website
    When User click on signin option
    And User enter email 'nilofar.nawabi@tekschool.us' and password 'Test@1234'
    And User click on login button
    Then User should be logged in into Account

     @registerAccount
  Scenario: Verify user can sign in into Retail Application
    Given User is on retail website
    When User click on Sign in option
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name     | email                 | password  | confirmPassword |
      | phantomn | phantomn@tekschool.us | Tek@12345 | Tek@12345       |
    And User click on SignUp button
    Then User should be logged into account page
