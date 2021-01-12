package testSuite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/Sell1.feature"}
		,glue= {"stepDefinition","base"}
		,tags= "@sanityTest"
		)
 public class Sell_TestRunner extends AbstractTestNGCucumberTests {

}