package testSuite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/dailydeal.feature"}
		,glue= {"stepDefinition"}
		,tags= "@tag"
		)


public class Dailydeal_TestRunner extends AbstractTestNGCucumberTests {

}

