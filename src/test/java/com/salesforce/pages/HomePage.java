package com.salesforce.pages;

import com.salesforce.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[@title ='App Launcher']")
    public WebElement appLauncher;


    @FindBy(xpath = "//input[@class='slds-input']")
    public  WebElement inputAppLauncher;

    @FindBy(xpath = "(//a[@class='slds-button slds-button_reset'])[2]")
    public WebElement leadsObjectDropdown;


    @FindBy(xpath = "//div[@class='menuItemsWrapper']/slot/one-app-nav-bar-menu-item[2]")
    public WebElement myLeadsOption;


    @FindBy(xpath = "(//button[@title='Show filters'])[1]")
    public WebElement filtersButton;


    @FindBy(xpath = "//div[.='Created Date']")
    public WebElement createdDateButton;

    @FindBy(xpath = "//label[.='Value']/../input")
    public  WebElement insertValueOfDate;

    @FindBy(xpath = "//button[.='Done']")
    public WebElement buttonDone;

    @FindBy(xpath = "(//button[.='Save'])[2]")
    public WebElement saveButton;


    @FindBy(xpath = "//table")
    public WebElement table;

    @FindBy(xpath = "(//span[@class='countSortedByFilteredBy'])[1]")
    public WebElement myLeadsNumbersText;



}
