package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"usage","html:target/cucumber-reports/Cucumberusage.html", "rerun:target/failedrerun.txt"},
features="@target/failedrerun.txt",
glue="StepDefinitions")
public class UsageReportSample extends AbstractTestNGCucumberTests{	

}
