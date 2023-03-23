Feature: 

  Background: 
    Given User is on retail website
    When User click on signin option
    And User enter email 'nilofar.nawabi@tekschool.us' and password 'Test@1234'
    And User click on login button
    And User should be logged in into Account

  @RetailAccountPage
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Nelofar' and Phone '7030000078'
    And User click on Update button
    Then user profile information should be updated

  @smokeTest1
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 7890123456789067 | Nilofar    |              08 |           2025 |          987 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added successfully'

  @SmokeTest2
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Master Card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber      | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 779870087712277 | Subhan     |              05 |           2025 |          789 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'
 @SmokeTest3
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country | fullName | phoneNumber | streetAddress | apt   | city      | state | zipCode |
      | USA     | Nilofar  | 7038709923  |   RingOld Pl  |5327   |Springfield| VA    | 22151   |
    And User click Add Your Address button
    Then a message should be displayed ‘Address Added Successfully’
