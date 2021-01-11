package testSuite;
//import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;





@RunWith(Cucumber.class)
@CucumberOptions(features = "featurefiles/SignIn.feature"

,glue = {"stepDefinition"},
			  tags = "@Ebay")
	

public class validLogin_Runner extends AbstractTestNGCucumberTests {



}
