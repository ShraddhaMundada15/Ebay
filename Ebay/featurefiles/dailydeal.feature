#Author: your.email@your.domain.com


@tag
Feature: Daily Deal page
  
 @tag1
 Scenario: Verify Daily Deal page
     
	      Given user is on eBay dashboard
	      When click on Daily Deal option
	      Then display Daily Deal page
	          
  @tag2
  Scenario: Verify to search for given product

        Given user is on Daily Deal page
        When enter product name which is available and click on the search button
        Then display related product and its discount
                
  @tag3
 Scenario: Verify to search for  product which is not available

        When enter product name which is not available and click on search button
        Then display no such deals
                 
                