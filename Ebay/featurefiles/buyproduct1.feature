#Author: your.email@your.domain.com


@ebay_buyproduct1
Feature: Select a product to buy


  Scenario: Verify to display categories page
    Given user is on homepage
    When user clicks buy option
    Then should display categories page
    
  Scenario: Verify to buy sporting products
    When user clicks sporting goods golf equipment
    And select category golf clubs callaway brand
    And select product
    Then display buy product page

  