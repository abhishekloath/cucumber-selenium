package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"progress","json:target/cucumber.json","html:target/html", },
		features = { "src/test/resources/featureFiles" },
		glue = {"com/stepDefinitions", "com/common"},
		monochrome = false,
		tags = "@test"
		)

public class testRunner {

	
	
}
