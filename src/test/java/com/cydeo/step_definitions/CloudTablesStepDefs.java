package com.cydeo.step_definitions;

import com.cydeo.pages.CloudTablePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class CloudTablesStepDefs {
    CloudTablePage cloudTablePage = new CloudTablePage();

    @Given("User is on cloudtables homepage")
    public void user_is_on_cloudtables_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cloudtables.url"));

        Assert.assertEquals("Editor | Editing for DataTables",Driver.getDriver().getTitle());

    }
    @When("User clicks on New button")
    public void user_clicks_on_new_button() {
    cloudTablePage.newBtn.click();
    }
    @When("User enters {string} to firstname field")
    public void user_enters_to_firstname_field(String firstname) {
        cloudTablePage.firstNameField.sendKeys(firstname);

    }
    @When("User enters {string} to lastname field")
    public void user_enters_to_lastname_field(String lastname) {
        cloudTablePage.lastNameField.sendKeys(lastname);

    }
    @When("User enters {string} to position field")
    public void user_enters_to_position_field(String position) {
        cloudTablePage.positionField.sendKeys(position);

    }
    @When("User enters {string} to salary field")
    public void user_enters_to_salary_field(String salary) {
        cloudTablePage.salaryField.sendKeys(salary);

    }
    @When("User clicks on create button")
    public void user_clicks_on_create_button() {

        cloudTablePage.createBtn.click();

    }

}
