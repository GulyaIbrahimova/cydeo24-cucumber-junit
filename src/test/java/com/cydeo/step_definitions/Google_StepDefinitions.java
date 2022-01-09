package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import javax.security.auth.login.Configuration;
import java.util.List;

public class Google_StepDefinitions {

    GoogleSearchPage searchPage = new GoogleSearchPage();
    //All these called is snippets
    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
    }
    @When("User searches for apple")
    public void user_searches_for_apple() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();


        searchPage.searchBar.sendKeys("apple" + Keys.ENTER);

    }
    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("User should be able to search for following:")
    public void userShouldBeAbleToSearchForFollowing(List<String> items) {
        System.out.println("items=" +items);


        for (String item : items) {
            searchPage.searchBar.clear();
            searchPage.searchBar.sendKeys(item+ Keys.ENTER);

        }

    }

    @When("User searches for {string}")
    public void userSearchesFor(String countryName) {
        System.out.println("Searching for capital city of "+ countryName);

        searchPage.searchBar.sendKeys("What is capital name "+ countryName+Keys.ENTER);
    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String capitalName) {

        System.out.println("Expected Capital City: " + capitalName);
        Assert.assertEquals(capitalName, searchPage.searchResultCityName.getText());


    }
}
