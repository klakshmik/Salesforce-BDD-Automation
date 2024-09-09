package com.salesforce.pages;

import com.salesforce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityTabAndTAskValidationPage {


    public ActivityTabAndTAskValidationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#upcoming-activities-section-00Qak000005ntmrEAA>div>ul>li") // all lists
    public WebElement filteredUpcomingTaskCreateBudgetPlan;

    @FindBy(xpath = "//div[@id='upcoming-activities-section-00Qak000005ntmrEAA']//ul/li[1]//a[@title='Submit Budget Plan for Review']")
    public WebElement upcomingTaskSubmitBudgetPlanForReview;

    @FindBy(xpath = "//div[@id='upcoming-activities-section-00Qak000005ntmrEAA']//ul/li[2]//a[@title='Create Budget Plan']")
    public  WebElement upcomingTaskCreateBudgetPlan;

    @FindBy(xpath = "//div[@class='slds-section open-activity-group openActivities slds-is-open']//ul/li[2]//a/lightning-icon[@title='Details for Create Budget Plan']/..")
    public WebElement expandDetails;

    @FindBy(xpath = "//div[@class='slds-item--detail description bodyText tenLinesScroll']")
    public WebElement descriptionBox;

    @FindBy(xpath = "(//div[@data-target-selection-name='d3d97191b9714f2388cd2ad681fdc4ed'])[2]/a")
    public WebElement dropdown;

    @FindBy(xpath = "//textarea[@role='textbox']")
    public  WebElement textBox;

    @FindBy(xpath = "//div[@title='Edit Comments']/..")
    public  WebElement editComments;


    @FindBy(xpath = "(//button[.='Save'])[2]")
    public  WebElement saveTextBtn;

    @FindBy(xpath = "(//a[.='Skip to the bottom of the activity timeline']/..//button)[1]")
    public WebElement gearIconFilters;


    @FindBy(xpath = "//span[.='Next 7 days']")
    public  WebElement radioBtnNext7Days;


    @FindBy(xpath = "//button[.='Apply']")
    public  WebElement apply;

    @FindBy(xpath = "//button[.='Show All Activities']")
    public WebElement showAllActivitiesBtn;


}
