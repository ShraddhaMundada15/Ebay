package testSuite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featurefiles/buyproduct1.feature","featurefiles/buyproduct2.feature"} /// which feature files to run
		,glue={"stepDefinition"}				//package names having the scripts for the feature file
		,tags= "@ebay_buyproduct1"			// the tags to run.... which are in feature file		
		)

public class Buy_TestRunner extends AbstractTestNGCucumberTests{

}
