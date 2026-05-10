package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty","html:target/cucumber-reports/TutorialsNinjaLoginReport.html"},
features="src/test/resources/com/features/TutorialsNinjalogin.feature",
glue="StepDefinitions")
public class TutorialsNinjaLoginRunner extends AbstractTestNGCucumberTests{

}
