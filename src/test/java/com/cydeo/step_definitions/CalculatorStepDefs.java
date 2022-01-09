package com.cydeo.step_definitions;

import com.cydeo.pages.CalculatorTestPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class CalculatorStepDefs {

    CalculatorTestPage calculatorTestPage = new CalculatorTestPage();

    @Given("User is on calculator page")
    public void user_is_on_calculator_page() {

        System.out.println("User is on calculator page");
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator.url"));

      /*
      Murodil didn't verify:  Assert.assertEquals("Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science", Driver.getDriver().getTitle());
       */
    }
    @Given("User clicks on {string} on calculator")
    public void user_clicks_on_on_calculator(String string) {
        System.out.println("User clicks on {"+string+"} on calculator");
        calculatorTestPage.clickOn(string);


    }
    @Then("result {string} should be displayed")
    public void result_should_be_displayed(String expResult) {
        System.out.println("actual result = "+ calculatorTestPage.result.getText().trim());

        Assert.assertEquals(expResult, calculatorTestPage.result.getText().trim());


    }


}
