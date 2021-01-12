#Author: your.email@your.domain.com


@register
Feature: SignIn Action Test

@tag1
  Scenario: verify register with invalid input
          Given user in on Ebay page
          When user clicks on the register enter invalid input and click Create account
          Then display error message
      
 @tag2       
  Scenario Outline: register a new user with valid input
  #				Given user in on Ebay page
          When user clicks on register and user enters <firstname>, <lastname>, <email> and <password> and click on Create an account
          Then user is on ebay page

    Examples: 
      |firstname|lastname|email|password|
	    |Raj|Sharma|shiv818@gmail.com|Swar@123a|