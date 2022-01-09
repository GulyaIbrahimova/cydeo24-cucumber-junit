package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(   plugin = {
        "html:target/cucumber-report.html",
        "rerun:target/rerun.txt",//stores failed scenarios names into rerun
        "json:target/cucumber.json"//generate json execution report to be used for html report


},
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false //false-> run the tests, true -> check the steps
       // tags="@rerun"

)

public class CukesRunner {

}
