package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    public LibraryLoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "inputEmail")
    public WebElement email;

    @FindBy(id="inputPassword")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    public  WebElement signInBtn;



}
