package com.salesforce.pages;

import com.salesforce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateDeleteDataPage {

   public  UpdateDeleteDataPage(){ PageFactory.initElements(Driver.getDriver(), this);
   }


    @FindBy(xpath = "(//span[.='Show more actions']/..)[3]/..")
    public WebElement dropdown1;


    @FindBy(xpath = "//a[@data-target-selection-name='sfdc:StandardButton.Task.Delete']")
    public  WebElement deleteOption;


    @FindBy(xpath = "(//input[@class='inputCheckbox'])[1]/..")
    public  WebElement checkboxUpper1;

    @FindBy(xpath = "(//input[@class='inputCheckbox'])[2]/..")
    public  WebElement checkboxLower2;


    @FindBy(xpath = "//span[.='Delete']/..")
    public  WebElement deleteBigBtn;



}
