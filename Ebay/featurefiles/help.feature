#Author: your.email@your.domain.com

Feature:
	Verify Help & Contact section

Scenario: verify help and contact secion is working
Given user is on ebay homepage
When click on help and contact link
Then user is on help and contact page

Scenario: verify buy as guest option is working
When user is on help and contact page
And click on buy as guest
Then user redirected to buy as guest page

Scenario: verify get help with an item that hasn't been arrived option is working
When user is on help and contact page
And click on get help with an item that has not been arrived
Then user redirected to get help with an item that has not been arrived page

Scenario: verify get help with a hacked account option is working
When user is on help and contact page
And click on get help with a hacked account
Then user redirected to get help with a hacked account page