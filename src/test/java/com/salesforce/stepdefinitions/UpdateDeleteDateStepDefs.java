package com.salesforce.stepdefinitions;

import com.salesforce.utilities.BrowserUtils;
import org.openqa.selenium.*;
import com.salesforce.pages.UpdateDeleteDataPage;
import com.salesforce.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateDeleteDateStepDefs {

    // Initialize page object BerthaBoxerTaskPage, WebDriver instance, and JavaScriptExecutor.
    WebDriver driver = Driver.getDriver();

    //Pages classes we're using to store all located WebElements in one place and if we need we call them from there
    //We can find them in pages folder for each page separate, also we can manage, update,delete them in one place.
    UpdateDeleteDataPage updateDeleteDataPage = new UpdateDeleteDataPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Given("user navigates to URL")
    public void userNavigatesToURL() {

        //user navigates to url
        String url = "https://sitetracker-1a-dev-ed.develop.lightning.force.com/lightning/r/Lead/00Qak000005ntmrEAA/view";
        driver.get(url);
    }

    @Then("clicks dropdown of first task and delete data from upcoming tasks")
    public void clicksDropdownOfFirstTaskAndDeleteDataFromUpcomingTasks() {

        // Click the first checkbox
        BrowserUtils.waitFor(3);
        js.executeScript("arguments[0].click();", updateDeleteDataPage.checkboxUpper1);
        BrowserUtils.waitFor(3);

        // Click the second checkbox
        js.executeScript("arguments[0].click();", updateDeleteDataPage.checkboxLower2);
        BrowserUtils.waitFor(3);

        //click dropdown to delete created tasks
        BrowserUtils.waitFor(3);
        js.executeScript("arguments[0].click();", updateDeleteDataPage.dropdown1);
        BrowserUtils.waitFor(3);

        //click delete option
        BrowserUtils.waitFor(3);
        updateDeleteDataPage.deleteOption.click();
        BrowserUtils.waitFor(3);

        // Click the final delete button
        updateDeleteDataPage.deleteBigBtn.click();
        BrowserUtils.waitFor(3);

    }
    }


