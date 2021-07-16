package com.expelo.challengingdom.automation.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com/expelo/challengingdom/automation/stepDefinitions",
        plugin ={"html:target/cucumber-html-report","json:target/report/cucumber.json"} ,
        monochrome = true,
        dryRun = false,
        tags = {"@EditButtonValidation"})
public class Runner {
}
