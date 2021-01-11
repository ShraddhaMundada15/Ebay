#Author: your.email@your.domain.com


@register
Feature: SignIn Action Test
@tag1
  Scenario Outline: verify register with invalid input
          Given user in on Ebay page
          When user clicks on the register and enters <firstname1>, <lastname1>, <email1> and <password1> and click Create account
          Then display error message

    Examples: 
      |firstname1|lastname1|email1|password1|
      |abc|xyz|swaragmailcom|123|
      
 @tag2       
  Scenario Outline: register a new user with valid input
          When user clicks on register and user enters <firstname>, <lastname>, <email> and <password> and click on Create an account
          Then user is on ebay page

    Examples: 
      |firstname|lastname|email|password|
	    |shil|jerry|shiv70@gmail.com|Swa@123|