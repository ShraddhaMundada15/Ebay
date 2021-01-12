package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HelpAndContact; 

public class HelpAndContactSteps 
{
		
		HelpAndContact p = new HelpAndContact();
		@Given("^user is on ebay homepage$")
	    public void user_is_on_ebay_homepage() throws Throwable 
		{
//	        p.openurl();
	    }

		@When("^click on help and contact link$")
	    public void click_on_help_and_contact_link() throws Throwable 
	    {
	        p.openHelp();
	    }

		@Then("^user is on help and contact page$")
	    public void user_is_on_help_and_contact_page() throws Throwable 
	    {
	       p.validateHelp();
	    }
	
		@And("^click on buy as guest$")
	    public void click_on_buy_as_guest() throws Throwable 
	    {
		     p.clickBuyaG();   
	    }
		
		@Then("^user redirected to buy as guest page$")
	    public void user_redirected_to_buy_as_guest_page() throws Throwable 
	    {
			p.validateBaG();
	    }
		
		@Then("^user redirected to get help with item not arrived page$")
	    public void user_redirected_to_get_help_with_item_not_arrived_page() throws Throwable
	    {
	       p.itemNotArrived();
	    }

		@And("^click on get help with item not arrived$")
	    public void click_on_get_help_with_item_not_arrived() throws Throwable 
	    {
	        p.validateItemNotArrived();
	    }
	    
	    @Then("^user redirected to get help with a hacked account page$")
	    public void user_redirected_to_get_help_with_a_hacked_account_page() throws Throwable 
	    {
	        p.hackedAccountHelp();
	    }

	    @And("^click on get help with a hacked account$")
	    public void click_on_get_help_with_a_hacked_account() throws Throwable 
	    {
	    	p.validateHackedAcoountHelp();
	    } 
	}
