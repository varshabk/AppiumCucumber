Feature: Products Page Feature

  Scenario: Verify products page details
    Given User is on products page
    And Verify the productname
    And Verify the productprice
    When user clicks on productname
    Then user should be on productdetails page
    
   
