#Author: your.email@your.domain.com


@ebay_buyproduct1
Feature: Buy a product


  Scenario: Verify to display shipping details page
    Given user is on buy product page	
    When user clicks buy it now
    And check if user is signed in
    Then display the shipping details page
    
   Scenario: Verify user enters details
    When user can click any payment option
    Then user able to enter payment details
    
   


