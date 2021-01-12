package testSuite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/help.feature"}
		,glue= {"stepDefinition","base"}
		,tags= "@tag"
		)

public class HnC_Testrunner extends AbstractTestNGCucumberTests {

}