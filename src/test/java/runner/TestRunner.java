package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		monochrome = true,
		glue="stepdefinition",
		plugin={"pretty","html:target/cucumber.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
