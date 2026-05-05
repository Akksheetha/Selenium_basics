package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty","html:target/cucumber-reports/Cucumber.html"},
features="src/test/resources/com/features/login.feature",
glue="StepDefinitions")
public class testngrunner extends AbstractTestNGCucumberTests{

}
