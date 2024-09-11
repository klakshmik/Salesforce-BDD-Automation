package com.salesforce.pages;

import com.salesforce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BerthaBoxerTaskPage {


    public BerthaBoxerTaskPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Bertha Boxer']")
    public WebElement berthaNameInTable;

    @FindBy(xpath = "//lightning-formatted-name[.='Ms. Bertha Boxer']")
    public  WebElement berthaRecord;

    @FindBy(xpath = "//li[@title='Activity']")
    public WebElement activityTab;
    @FindBy(xpath = "//button[@title='New Task']")
    public  WebElement newTaskButton;

    @FindBy(xpath = "//label[.='Subject']/..//input")
    public  WebElement subjectField;
    @FindBy(xpath = "//span[.=\"Due Date\"]/../..//input")
    public  WebElement dueDateField;

    @FindBy(xpath = "//span[.='Status']/../../div//a")
    public  WebElement relatedField;

    @FindBy(xpath = "(//a[@class='deleteAction'])[2]")
    public  WebElement relatedFieldDelete;

    @FindBy(xpath = "//span[.='Related To']/../../div//input")
    public WebElement assignedTo;

    @FindBy(css = ".lookup__item.default.uiAutocompleteOption.forceSearchInputLookupDesktopOption")
    public WebElement assignedToChoseOne;

    @FindBy(xpath = "//span[.='Status']/../..//a")
    public  WebElement statusField;

    @FindBy(xpath = "//a[.='In Progress']")
    public  WebElement statusFieldInProgress;

    @FindBy(xpath = "//li/a[.='Not Started']")
    public  WebElement statusNotStarted;

    @FindBy(xpath = "(//span[.='Save']/..)[3]")
    public  WebElement saveButton;

    @FindBy(xpath = "//body/div[6]/div[1]/div[1]/div[1]")
    public  WebElement popupNotification;

}
