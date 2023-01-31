Feature: Login Scenario
  Scenario Outline: Check login with invalid details
    Given I enter username as "<username>"
    When And password as "<password>"
    Then I click on login button

    Examples: 
      | username  | password | 
      | sample |     123 | 
      | name2 |     7 | 
      
 Scenario: Check login with valid details
 Given The user enters username as "username"
 And user enters password as "password"
 And user clicks login
 Then user should display with "title" as title