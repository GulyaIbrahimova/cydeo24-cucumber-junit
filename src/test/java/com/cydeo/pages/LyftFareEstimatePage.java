package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LyftFareEstimatePage {
    WebDriver driver;

    public LyftFareEstimatePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(name = "fare-start")
    public WebElement picUpLocation;

    @FindBy(name = "fare-end")
    public WebElement dropOffLocation;

    @FindBy(xpath = "//span[text()='Get estimate']")
    public WebElement getEstimateBTn;

    @FindBy(xpath = "//h3[.='RIDE TYPES']")
    public WebElement rideTypesHeader;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    public WebElement lyftPrice;

    @FindBy(xpath = "//small[.='Please select a valid location.']")
    public WebElement errorMsg;

    public void enterPickUpLocation(String location){
        picUpLocation.sendKeys(location);

    }
    public void enterDropOffLocation(String location){
        dropOffLocation.sendKeys(location);
    }
    public void clickOnEstimateBTN(){
        getEstimateBTn.click();
    }
}
