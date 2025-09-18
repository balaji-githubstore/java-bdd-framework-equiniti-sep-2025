package com.eq.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/feature"}
		,glue = {"com.eq.steps"}
		,dryRun = true
	    //,publish = true	
	    ,plugin = {"pretty","html:target/cucumber-report.html"}
		,tags="@register"
		)

public class RunnerTest extends AbstractTestNGCucumberTests {

}
