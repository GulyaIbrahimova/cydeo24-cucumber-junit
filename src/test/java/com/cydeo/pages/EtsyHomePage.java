package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyHomePage {
    WebDriver driver;

    public EtsyHomePage(){
        driver=Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="global-enhancements-search-query")
    public WebElement etsySearchField;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchButton;



    /**
     accepts a String and searches for it on Etsy
     * @param item
     searchFor(Iphone case
     */

    public void searchFor(String item){
        etsySearchField.clear();
        etsySearchField.sendKeys(item);
        searchButton.click();

    }



}
