package stepDefinition;

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
	        p.openurl();
	    }

	    @When("^click on help and ontact link$")
	    public void click_on_help_and_ontact_link() throws Throwable 
	    {
	        p.openHelp();
	    }

	    @Then("^user is on help and ontact page$")
	    public void user_is_on_help_and_ontact_page() throws Throwable 
	    {
	       p.validateHelp();
	    }
	}