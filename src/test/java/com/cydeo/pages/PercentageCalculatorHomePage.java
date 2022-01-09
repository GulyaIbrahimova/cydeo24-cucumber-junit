package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PercentageCalculatorHomePage {
    public PercentageCalculatorHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@size='3']")
    public WebElement inputPercent;

    @FindBy(xpath = "//input[@size='7']")
    public WebElement inputValue;

    @FindBy(xpath = "(//input[@value='Calculate'])[1]")
    public WebElement calculateBTN;

    @FindBy(xpath = "(//input[@size='6'])[1]")
    public WebElement resultMsg;



}/**
 Note: That is why I took from parent.


 @FindBy (xpath = "//form[@id='f1']//input[@size='3']")
 public WebElement percent;

 @FindBy (xpath = "//form[@id='f1']//input[@size='7']")
 public WebElement input;

 @FindBy (xpath = "//form[@id='f1']//input[@value='Calculate']")
 public WebElement calculateButton;

 @FindBy(xpath = "//form[@id='f1']//input[@readonly='readonly']")
 public WebElement resultFiled;
 */
