package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty","html:target/cucumber-reports/Cucumber3.html"},
features="src/test/resources/com/features/Scenario_Outline.feature",
glue="StepDefinitions")
public class ScenarioOutlineRunner extends AbstractTestNGCucumberTests{

}
