#Author: your.email@your.domain.com

@tag
Feature:
	Verify Help & Contact section

Scenario: verify help and contact section is working
Given user is on ebay homepage
When click on help and contact link
Then user is on help and contact page

Scenario: verify buy as guest option is working
When user is on help and contact page
And click on buy as guest
Then user redirected to buy as guest page

Scenario: verify get help with item not arrived option is working
When user is on help and contact page
And click on get help with item not arrived
Then user redirected to get help with item not arrived page

Scenario: verify get help with a hacked account option is working
When user is on help and contact page
And click on get help with a hacked account
Then user redirected to get help with a hacked account page