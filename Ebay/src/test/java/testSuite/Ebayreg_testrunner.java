package testSuite;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


 @RunWith(Cucumber.class)
 @CucumberOptions(
		features= {"featurefiles/regeay.feature"}
		,glue= {"stepDefinition"}
		,tags= {"@register"}
		)
 
 
 public class Ebayreg_testrunner extends AbstractTestNGCucumberTests {
	
 }