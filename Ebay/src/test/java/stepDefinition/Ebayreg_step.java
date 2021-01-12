package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Ebay_reg;
import pages.Sign_In_Pages;

public class Ebayreg_step {

    Ebay_reg es =new Ebay_reg();
//    Sign_In_Pages signin = new Sign_In_Pages();
    
	@Given("^user in on Ebay page$")
    public void user_in_on_ebay_page() throws Throwable {
		es.openbrowser();
		es.openurl();
    }
	
	@When("^user clicks on the register enter invalid input and click Create account$")
    public void user_clicks_on_the_register_enter_invalid_input_and_click_create_account() throws Throwable 
	{
	    es.registered_invalid();
	}

    @Then("^display error message$")
    public void display_error_message() throws Throwable {
	    // es.verify_errormessage();
	}
	    
    @When("^user clicks on register and user enters (.+), (.+), (.+) and (.+) and click on Create an account$")
    public void user_clicks_on_register_and_user_enters_and_and_click_on_create_an_account(String firstname, String lastname, String email, String password) throws Throwable {
    	es.registered_credentials(firstname, lastname, email, password);
    }

    @Then("^user is on ebay page$")
    public void user_is_on_ebay_page() throws Throwable {
        es.verify_Title();
    }
  
}

