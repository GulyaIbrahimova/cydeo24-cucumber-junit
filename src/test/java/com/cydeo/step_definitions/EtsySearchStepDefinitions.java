package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyAllCategoriesPage;
import com.cydeo.pages.EtsyHomePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;

import io.cucumber.java.en.*;
import org.bouncycastle.util.Strings;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsySearchStepDefinitions {
    WebDriver driver;
    @Given("User is on Etsy home page")
    public void user_is_on_etsy_home_page() {
        driver =Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("etsy.url"));

    }
    @Then("page title should be as a expected")
    public void page_title_should_be_as_a_expected() {
        Assert.assertEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", driver.getTitle());


    }
    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
//        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
//        searchBox.sendKeys("wooden spoon" + Keys.ENTER);
//created method
        EtsyHomePage homePage = new EtsyHomePage();
        homePage.searchFor("wooden spoon");



    }
    @Then("Page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {
//        Assert.assertEquals("Wooden spoon | Etsy", driver.getTitle() );
       // BrowserUtils.sleep(5); explicit wait is better


        Assert.assertTrue(driver.getTitle().contains("Wooden spoon"));
    }

    @When("User searches for empty value")
    public void userSearchesForEmptyValue() {
        EtsyHomePage homePage = new EtsyHomePage();
        homePage.searchFor("");
    }


    @Then("All categories should be displayed")
    public void allCategoriesShouldBeDisplayed() {

        //wait for title to change to all categories

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs("All categories | Etsy"));

        Assert.assertEquals("All categories | Etsy", driver.getTitle());

        EtsyAllCategoriesPage allCategoriesPage = new EtsyAllCategoriesPage();
        Assert.assertTrue(allCategoriesPage.allCategoriesHeader.isDisplayed());

    }

}
