package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 Similar to TestBase.java in TestNG framework
 We open close browsers here

 */
public class Hooks {
    @Before
    public void setUp(){
        System.out.println("BEFORE - setUp method is running before the scenario");

    }
    @After
    public void tearDownScenario(Scenario scenario){
        /**
         * Scenario scenario: represents current running cucumber scenario
         * -cast webdriver to TakesScreenshot interface.(TakesScreenshot)Driver.getDriver()
         * -call getScreenShotAs method and output type as OutputType.BYTES
         * -save the result into byte[] array: byte[] image
         * -attach the image into the scenario html report: scenario.attach(image, "image/png", scenario.getName());
         * - if scenario fails for any reason it will automatically take screenshot
         */

        if (scenario.isFailed()) {
            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }
            System.out.println("AFTER - tearDown scenario is running");
            //Driver.closeDriver();

    }
    /**
    @AfterStep - runs after each scenario step
    - takes screenshot and attaches to the report for each step
    - normally not needed but your project might require at some point.
     @param scenario


     @AfterStep()
     public void tearDownStep(Scenario scenario) {
        byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(image, "image/png", scenario.getName());
    }

    */
}
