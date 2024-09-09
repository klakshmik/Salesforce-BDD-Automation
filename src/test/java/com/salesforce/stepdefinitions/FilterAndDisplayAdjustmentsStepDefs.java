package com.salesforce.stepdefinitions;

import com.salesforce.pages.ActivityTabAndTAskValidationPage;
import io.cucumber.java.en.And;


import com.salesforce.utilities.BrowserUtils;
import com.salesforce.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import static org.junit.Assert.*;




public class FilterAndDisplayAdjustmentsStepDefs {

    // Initialize page object BerthaBoxerTaskPage, WebDriver instance, and JavaScriptExecutor.
    WebDriver driver = Driver.getDriver();

    //Pages classes we're using to store all located WebElements in one place and if we need we call them from there
    //We can find them in pages folder for each page separate, also we can manage, update,delete them in one place.
    ActivityTabAndTAskValidationPage activityTaskValidationPage = new ActivityTabAndTAskValidationPage();

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @And("navigate to Url")
        public void navigateToUrl() {
            String url = "https://sitetracker-1a-dev-ed.develop.lightning.force.com/lightning/r/Lead/00Qak000005ntmrEAA/view";
            driver.get(url);
        }

    // Step to click the gear icon next to Filters, set the date range to the next seven days, and apply the filter
    @When("user clicks gear icon next to Filters and set the date range to the next seven days and apply")
    public void userClicksGearIconNextToFiltersAndSetTheDateRangeToTheNextSevenDaysAndApply() {

        // Click the gear icon for filters
        BrowserUtils.waitFor(5);   //wait 3 sec
        js.executeScript("arguments[0].click();", activityTaskValidationPage.gearIconFilters);
        BrowserUtils.waitFor(3);  //wait 3 sec

        // Select the radio button for the next 7 days
        activityTaskValidationPage.radioBtnNext7Days.click();
        BrowserUtils.waitFor(3);

        // Apply the filter
        activityTaskValidationPage.apply.click();
        BrowserUtils.waitFor(2);

    }

    // Step to validate that only the specified task is displayed after applying the filter
    @Then("Validate that only the {string} task is displayed only")
    public void validateThatOnlyTheTaskIsDisplayed(String expectedText) {

        // Assert that the expected task is displayed
        BrowserUtils.waitFor(5);
        assertTrue(activityTaskValidationPage.filteredUpcomingTaskCreateBudgetPlan.isDisplayed());

        // Get the text of the displayed task
        String actualTextForUpcTaskCreat = activityTaskValidationPage.filteredUpcomingTaskCreateBudgetPlan.getText();

        // Assert that the text contains the expected task name
        BrowserUtils.waitFor(2);
        assertTrue(actualTextForUpcTaskCreat.contains(expectedText));

        // Define the task that should not be displayed
        String upcomingTaskSubmitBudgetPlanForReview = "Submit Budget Plan for Review";
        BrowserUtils.waitFor(4);

        // Assert that the text does not contain the unexpected task
        assertTrue(!actualTextForUpcTaskCreat.contains(upcomingTaskSubmitBudgetPlanForReview));
        BrowserUtils.waitFor(3);

    }

    // Step to click the button to show all activities
    @Then("click all Activities")
    public void clickAllActivities() {

        // Click the button to show all activities
        BrowserUtils.waitFor(2);
        js.executeScript("arguments[0].click();", activityTaskValidationPage.showAllActivitiesBtn);
        BrowserUtils.waitFor(5);
        // Wait for 5 seconds to ensure all activities are displayed

        //This next step was created before and will run from different class of step definition
        //ActivityTabAndTaskValidation.feature  and ActivityTabAndTaskValidationStepDefs
        // "Then user should see both tasks displayed"

        // !!! !!! !!!
        //When We have repeated (the same) steps in the step definition classes that was created before they will run
        //we don`t have to create those steps again.
    }

}
