package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Dailydealpage;

public class Dailydeal_stepDefinition
{
	
     Dailydealpage ddp=new Dailydealpage();
     
	 @Given("^user is on eBay dashboard$")
	    public void user_is_on_ebay_dashboard() throws Throwable
	   {
//	      ddp.openurl();  
	    }

	    @When("^click on Daily Deal option$")
	    public void click_on_daily_deal_option() throws Throwable
	    {
	    	ddp.dailydeal_Pageoption();
	    }

	    @Then("^display Daily Deal page$")
	    public void display_daily_deal_page() throws Throwable 
	   {
	       ddp.dailydealpage_Validation();
	   }
	    

	    @Given("^user is on Daily Deal page$")
	    public void user_is_on_daily_deal_page() throws Throwable
	    {
	        
	    }

	    @When("^enter product name which is available and click on the search button$")
	    public void enter_product_name_which_is_available_and_click_on_the_search_button() throws Throwable 
	    {
	        ddp.search_ProuductAvailable();
	    }

	    @Then("^display related product and its discount$")
	    public void display_related_product_and_its_discount() throws Throwable 
	    {
	        ddp.productAvailable_Validation();
	    }
	    
	    @When("^enter product name which is not available and click on search button$")
	    public void enter_product_name_which_is_not_available_and_click_on_search_button() throws Throwable 
	    {
	       ddp.search_ProuductNotAvailable();
	    }

	    @Then("^display no such deals$")
	    public void display_no_such_deals() throws Throwable 
	    {
	        ddp.productNotAvailable_Validation();
	    }

	}

