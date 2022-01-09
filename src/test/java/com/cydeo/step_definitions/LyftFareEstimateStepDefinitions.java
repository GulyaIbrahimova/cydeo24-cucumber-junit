package com.cydeo.step_definitions;

import com.cydeo.pages.LyftFareEstimatePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LyftFareEstimateStepDefinitions {
    WebDriver driver;
    LyftFareEstimatePage lyftFareEstimatePage = new LyftFareEstimatePage();

    @Given("User is on lyft fare estimate page")
    public void user_is_on_lyft_fare_estimate_page() {
        driver= Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("lyft.fare.estimate.url"));
        String expTitle ="Get Fare Estimates for Your City - Lyft Price Estimate | Lyft";
        Assert.assertEquals("Lyft fare estimate page is not displayed",expTitle, driver.getTitle());


    }

    @When("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String pickUpLocation) {

        //need to add page object class for the Lyft estimate page
        lyftFareEstimatePage.enterPickUpLocation(pickUpLocation);

    }

    @And("User enters {string} to drop off address")
    public void user_enters_to_drop_off_address(String dropOffLocation) {
   // lyftFareEstimatePage.dropOffLocation.sendKeys(dropOffLocation);

        lyftFareEstimatePage.enterDropOffLocation(dropOffLocation);
    }

    @And("User click on get estimate button")
    public void user_click_on_get_estimate_button() {

       lyftFareEstimatePage.clickOnEstimateBTN();
       BrowserUtils.sleep(1);
        lyftFareEstimatePage.clickOnEstimateBTN();
        BrowserUtils.sleep(2);



    }

    @Then("User should see estimated prices")
    public void user_should_see_estimated_prices() {

        Assert.assertTrue(lyftFareEstimatePage.rideTypesHeader.isDisplayed());
        System.out.println("Lyft estimated price and time " + lyftFareEstimatePage.lyftPrice.getText());

    }

    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {
        Assert.assertTrue("Error message is not displayed",lyftFareEstimatePage.errorMsg.isDisplayed());

    }
}
