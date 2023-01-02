package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/Login.feature",
glue = "StepDefination", dryRun = false,
monochrome = true,
plugin = {"pretty","html:target/HtmlReports/test-output.html","json:target/Json/Report.json","junit:target/Junit/Report.xml"},
tags = "@smoke"

)
public class TestRunner {
}
