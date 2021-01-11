package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
//import cucumber.api.junit.Cucumber;
import pages.Sign_In_Pages;

//import org.junit.runner.RunWith;
public class Sign_In_Step 
{
	Sign_In_Pages login=new Sign_In_Pages(); 
	
	@Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable 
	{
        login.openurl();
    }

    @When("^Enter valid username and password and click login$")
    public void enter_valid_username_and_password_and_click_login() throws Throwable 
    {
       login.login();
    }

    @Then("^user should login success$")
    public void user_should_login_success() throws Throwable
    {
       login.checkloginsuccess();
    }
    
    @When("^enter valid (.+) and invalid (.+) and login$")
    public void enter_valid_and_invalid_and_login(String username, String password) throws Throwable
    {
        login.validateLogin(username, password);
    }

    @Then("^should display error message$")
    public void should_display_error_message() throws Throwable
    {
        login.checkloginsuccess();
    }
}


