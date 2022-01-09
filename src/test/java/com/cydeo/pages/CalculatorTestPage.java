package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorTestPage {

public CalculatorTestPage(){

    PageFactory.initElements(Driver.getDriver(),this);

}

public void clickOn(String button){
    WebElement elem = Driver.getDriver().findElement(By.xpath("//span[.='"+button+"']"));
   elem.click();
}

    @FindBy(id="sciOutPut")
    public WebElement result;


    /**
     method for more than 1 digit nums:

     public void clickOn(String button){

     if (button.length()>1){
     String[]arr=button.split("");

     for (String each: arr){
     Driver.getDriver().findElement(By.xpath("//span[.='"+each+"']")).click();
     }
     }else {
     Driver.getDriver().findElement(By.xpath("//span[.='"+button+"']")).click();
     }
     }
     */


}
