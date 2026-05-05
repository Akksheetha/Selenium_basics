package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
	    plugin = {"pretty", "html:target/cucumber-reports/Cucumber2.html"},
	    features = "src/test/resources/featureFiles/login.feature",
	    glue = "StepDefinitions" , tags = "@ValidCredentials"
	)
public class JUnitRunner  
{

}