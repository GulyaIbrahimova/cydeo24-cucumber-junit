package com.cydeo.step_definitions;

import com.cydeo.pages.PercentageCalculatorHomePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PercentageCalculatorStepDefs {
    WebDriver driver;
    PercentageCalculatorHomePage calculatorHomePage = new PercentageCalculatorHomePage();
    @Given("User is on percentage calculator page")
    public void userIsOnPercentageCalculatorPage() {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("percentage.url"));
        Assert.assertEquals("Percentage Calculator", driver.getTitle());

    }

    @Then("User should see following calculations:")
    public void userShouldSeeFollowingCalculations(Map<Integer,Integer> values) {
        System.out.println("values = " + values);
        calculatorHomePage.inputPercent.sendKeys("5");
        for (Integer keyValue  : values.keySet()) {
            calculatorHomePage.inputValue.clear();
            calculatorHomePage.inputValue.sendKeys(keyValue+""+ Keys.ENTER);
            System.out.println("Input VALUE = " + keyValue);
            System.out.println("EXPECTED 5% VALUE = " + calculatorHomePage.resultMsg.getAttribute("value"));
            System.out.println("=========================");

            //assert that expected %5 value matches the actual calculated value. Then go home
            Assert.assertEquals(values.get(keyValue)+"", calculatorHomePage.resultMsg.getAttribute("value"));

           /*
           Or both Integer:
           Assert.assertEquals(values.get(keyValue), Integer.valueOf(calculatorHomePage.resultMsg.getAttribute("value")));

            */
            //Integer.parseInt -----> return primitive types
            //   Integer.valueOf-------> return Object type
        }
    }
}
