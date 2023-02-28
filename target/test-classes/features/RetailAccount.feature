Feature: 

  Background: 
    Given User is on retail website
    When User click on signin option
    And User enter email 'nilofar.nawabi@tekschool.us' and password 'Test@1234'
    And User click on login button
    And User should be logged in into Account

  @smokeTest
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Nelofar' and Phone '7030000078'
    And User click on Update button
    Then user profile information should be updated

  @dryRun
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      | value      | value      | value           | value          | value        |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added successfully'
