package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="company.stepDefinations",
monochrome=true,tags= "@Regression",plugin= {"html:target/cucumber.html"})//tags= "@Regression"
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
}
