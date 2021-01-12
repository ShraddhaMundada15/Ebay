package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Buy_SelectProduct;
import pages.Buy_ShippingDetails;

public class Buy_stepDefinition 
{
	
	Buy_SelectProduct sp = new Buy_SelectProduct();
	Buy_ShippingDetails sd = new Buy_ShippingDetails();

	 @Given("^user is on homepage$")
	    public void user_is_on_homepage() throws Throwable
	{
//		sp.openurl();
    }

	@When("^user clicks buy option$")
    public void user_clicks_buy_option() throws Throwable 
    {
		sp.click_buy();
    }

    @Then("^should display categories page$")
    public void should_display_categories_page() throws Throwable 
    {
    }
    
    @When("^user clicks sporting goods golf equipment$")
    public void user_clicks_sporting_goods_golf_equipment() throws Throwable 
    {
    	sp.sporting_goods();
    }

    @Then("^display buy product page$")
    public void display_buy_product_page() throws Throwable {
    }

    @And("^select category golf clubs callaway brand$")
    public void select_category_golf_clubs_callaway_brand() throws Throwable
    {
    	sp.select_brand();
    }

    @And("^select product$")
    public void select_product() throws Throwable 
    {
    	sp.select_product();
    }
    
    @Given("^user is on buy product page$")
    public void user_is_on_buy_product_page() throws Throwable
    {
    	sd.buypage_title();
    }

    @When("^user clicks buy it now$")
    public void user_clicks_buy_it_now() throws Throwable
    {
    	sd.click_buyitnow();
    	sd.shippingpage_title();
    }

    @Then("^display the shipping details page$")
    public void display_the_shipping_details_page() throws Throwable 
    {
    }

    @And("^verify if user is signed in$")
    public void verify_if_user_is_signed_in() throws Throwable {
    	
        System.out.println("User signed in");
    }

    @When("^user can click any payment option$")
    public void user_can_click_any_payment_option() throws Throwable 
    {
    	sd.click_cardpayment();
    }

    @Then("^user able to enter payment details$")
    public void user_able_to_enter_payment_details() throws Throwable 
    {
    	sd.paymentdetails();
    }
    
}
