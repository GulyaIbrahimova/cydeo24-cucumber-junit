package com.cydeo.step_definitions;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Library_LoginDefinitions {

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);

    @Given("User is on the Library login page")
    public void user_is_on_the_library_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));

        Assert.assertEquals(Driver.getDriver().getTitle(), "Login - Library");

    }
    @When("User enters valid email address and password")
    public void user_enters_valid_email_address_and_password() {

        libraryLoginPage.email.sendKeys("librarian13@library");
        libraryLoginPage.password.sendKeys("Sdet2022*");
    }
    @When("User clicks on Sing in button")
    public void user_clicks_on_sing_in_button() {
        libraryLoginPage.signInBtn.click();


    }
    @Then("User should be able to see three models on the page")
    public void user_should_be_able_to_see_models_on_the_page( ) {


        List<WebElement> modules= Driver.getDriver().findElements(By.xpath("//span[@class='title']"));

        System.out.println(modules.size());
        int expectedModuleNum = 3;
        Assert.assertEquals(expectedModuleNum, modules.size() );



    }


}
