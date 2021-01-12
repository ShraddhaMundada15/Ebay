#Author: your.email@your.domain.com

@sanityTest
Feature: Sell Product Option
  
  
  Scenario: Verify to display categories page
    Given user is on the homepage
		When user clicks sell option
		Then display browse category page
    

  Scenario: Verify to sell mobiles
		When user clicks browse categories
		And select cellphones mobiles
		Then display create your listing
		
		
	Scenario: Verify Preview button
		When user enters listing details for preview
		And clicks on preview button
		Then item should be previewed
		
		
	Scenario: Verify item is listed
		When user enters listing details
		And clicks list item
		Then item should be listed
		
		
	
  	
	
		
		
		
	
  
 
