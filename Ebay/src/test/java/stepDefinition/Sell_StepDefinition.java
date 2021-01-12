package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Sell_ItemListing;
import pages.Sell_SelectCategory;

public class Sell_StepDefinition{
	
	Sell_ItemListing l= new Sell_ItemListing();
	Sell_SelectCategory c= new Sell_SelectCategory(); 
	
		@Given("^user is on the homepage$")
		public void user_is_on_the_homepage() throws Throwable
		{
       
		}
	    @When("^user clicks sell option$")
	    public void user_clicks_sell_option() throws Throwable 
	    {
	    	c.sellProduct();
	    }

	    @Then("^display browse category page$")
	    public void display_browse_category_page() throws Throwable
	    {
	    	
	    	c.validateBrowseCategory();
	    		       
	    }
	    @When("^user clicks browse categories$")
	    public void user_clicks_browse_categories() throws Throwable
	    {
	    	c.selectCategory();
	    }

	    @Then("^display create your listing$")
	    public void display_create_your_listing() throws Throwable 
	    {
	    	c.validatelisting();
	        
	    }

	    @And("^select cellphones mobiles$")
	    public void select_cellphones_mobiles() throws Throwable
	    {
	        
	        c.cellphones();
	    	c.mobiles();
	    }
	    @When("^user enters listing details for preview$")
	    public void user_enters_listing_details_for_preview() throws Throwable 
	    {
	    	l.Details();
	    }

	    @Then("^item should be previewed$")
	    public void item_should_be_previewed() throws Throwable
	    {
	    	l.validatePreview();	    	
	    }

	    @And("^clicks on preview button$")
	    public void clicks_on_preview_button() throws Throwable
	    {
	    	l.preview();
	    }
	    @When("^user enters listing details$")
	    public void user_enters_listing_details() throws Throwable
	    {
	    	//l.Details();
	    }

	    @Then("^item should be listed$")
	    public void item_should_be_listed() throws Throwable
	    {
	    	l.validatelistingProduct();
	    }

	    @And("^clicks list item$")
	    public void clicks_list_item() throws Throwable
	    {
	    	l.ListAnItem();
	    }
	   
	   

	   
	}
