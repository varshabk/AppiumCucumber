Feature: Checking the checkout feature
#Background: 
#Given user is on products page
#    Given User clicks on product name
#    And user verfies product details 
#    When user clicks add to cart
Scenario: Checkout page details
Given User clicks on Checkout button
And user enters the following data
|fname|address1|city|state|zipcode|country|
|rebecca|silverlane|peru|peru|39010|peru|
And user clicks on payment page
Scenario: Payment Page details
Given User is on payment page
And user enters details as below
|fname|cardnum|expdate|securecode|
|rebecca|608904638096242|0324|873|
And user clicks on review order button
Then he should displayed with review order page
Scenario: Review Pge details
Given User is on review page
When user verfies the review page details
And user clicks on place order button
Scenario: Verify thank you page details
Given user is on thank you page
Then verify the description
And verify the order status