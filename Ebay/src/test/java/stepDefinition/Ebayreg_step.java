package stepDefinition;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Ebay_reg;

public class Ebayreg_step {

    Ebay_reg es =new Ebay_reg();
    
	@Given("^user in on Ebay page$")
    public void user_in_on_ebay_page() throws Throwable {
		es.openbrowser();
		es.openurl();
    }
	 @When("^user clicks on the register and enters (.+), (.+), (.+) and (.+) and click Create account$")
	 public void user_clicks_on_the_register_and_enters_and_and_click_create_account(String firstname1, String lastname1, String email1, String password1) throws Throwable {
	       es.registered_invalid(firstname1, lastname1, email1, password1);
	    }


    @Then("^display error message$")
    public void display_error_message() throws Throwable {
	    // es.verify_errormessage();
	}

	    
    @When("^user clicks on register and user enters (.+), (.+), (.+) and (.+) and click on Create an account$")
    public void user_clicks_on_register_and_user_enters_and_and_click_on_create_an_account(String firstname, String lastname, String email, String password) throws Throwable {
    	es.registered_credintials(firstname, lastname, email, password);
    }

    @Then("^user is on ebay page$")
    public void user_is_on_ebay_page() throws Throwable {
        es.verify_Title();
    }
  
}

