Feature: Product details feature
#Background: Common to all 
#Given User enters "username" and "password"
#And user verifies product title
  Scenario: Verify product details
    Given User clicks on product name
    And user verfies product details 
    When user clicks add to cart
    Then user verifies cartpage details
   