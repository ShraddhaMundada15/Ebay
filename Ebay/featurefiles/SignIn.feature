#Author: simranchhaparwal3@gmail.com
@Ebay
Feature: Validate Login

@invalidLogin
  Scenario Outline: validate login for invalid inputs
  	Given user is on login page
    When enter valid <username> and invalid <password> and login
    Then should display error message
    Examples: 
      | username  | password |  
      | venkatgn.gutta@gmail.com |  |

 @validLogin
  Scenario: validate login for valid input data
    Given user is on login page
    When Enter valid username and password and click login
    Then user should login success