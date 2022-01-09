package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class DiceJobSearchStepDefs {

    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        System.out.println("USER IS ON DICE HOME PAGE...");

        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));

    }
    @When("User enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() {
        System.out.println("USER ENTERS JAVA AND 92071...");

        WebElement keyword = Driver.getDriver().findElement(By.id("typeaheadInput"));
        WebElement zipcode = Driver.getDriver().findElement(By.id("google-location-search"));

        keyword.sendKeys("java");
        zipcode.sendKeys("92117" + Keys.ENTER);
    }
    @Then("User should see search results")
    public void user_should_see_search_results() {
        System.out.println("USER SHOULD SEE SEARCH RESULTS...");
        BrowserUtils.sleep(2);
        WebElement jobCount = Driver.getDriver().findElement(By.id("totalJobCount"));
        System.out.println("JOB COUNT = " + jobCount.getText());
        Driver.closeDriver();

    }
}
