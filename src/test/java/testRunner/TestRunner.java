package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features",
glue = "StepDefination", dryRun = false,
monochrome = true,
plugin = {"pretty","html:test-output.html"},
tags = "@smoke"

)
public class TestRunner {
}
