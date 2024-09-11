package com.salesforce.stepdefinitions;

import com.salesforce.pages.ActivityTabAndTAskValidationPage;
import com.salesforce.utilities.BrowserUtils;
import com.salesforce.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActivityTabAndTaskValidation {


    // Initialize page object BerthaBoxerTaskPage, WebDriver instance, JavaScriptExecutor
    //We can call properties, and methods from them

    //Pages classes we're using to store all located WebElements in one place and if we need we call them from there
    //We can find them in pages folder for each page separate, also we can manage, update,delete them in one place.
    ActivityTabAndTAskValidationPage activityTaskValidationPage = new ActivityTabAndTAskValidationPage();
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Given("user navigates to Url")
    public void userNavigatesToUrl() {

        //wait for 2 sec
        BrowserUtils.waitFor(2);

        //navigate to given url page Bertha Boxer Lead
        String url = "https://sitetracker-1a-dev-ed.develop.lightning.force.com/lightning/r/Lead/00Qak000005ntmrEAA/view";
        driver.get(url);

        //wait for 2 sec
        BrowserUtils.waitFor(2);
    }

    @Then("user should see both tasks displayed")
    public void i_should_see_both_tasks_displayed() {

        // verify both tasks are displayed
        assertTrue(activityTaskValidationPage.upcomingTaskCreateBudgetPlan.isDisplayed());
        BrowserUtils.waitFor(2);

        assertTrue(activityTaskValidationPage.upcomingTaskSubmitBudgetPlanForReview.isDisplayed());
        BrowserUtils.waitFor(2);

    }

    @When("I click the expand icon for the Create Budget Plan task")
    public void iClickTheExpandIconForTheCreateBudgetPlanTask() {

        //using JavaScriptExecutor interface to execute script (click() method)
        js.executeScript("arguments[0].click();", activityTaskValidationPage.expandDetails);
        BrowserUtils.waitFor(5);

    }

    // Step to verify the description section is blank
    @Then("Description section should be blank")
    public void descriptionSectionShouldBeBlank() {

        //get text from description box
        String str = activityTaskValidationPage.descriptionBox.getText();
        BrowserUtils.waitFor(2);

        // check if description box is blank
        assertTrue("Description box is not empty and unexpected", str.isEmpty());
        BrowserUtils.waitFor(5);
    }


    // Step to edit comments and update the description
    @Then("click dropdown and select Edit comments text {string}")
    public void clickDropdownAndSelectEditCommentsText(String budgetForQ4) {

        // using JavaScript Executor to click dropdown to edit comments
        js.executeScript("arguments[0].click();", activityTaskValidationPage.dropdown);
        BrowserUtils.waitFor(3);

        //click to edit comments
        activityTaskValidationPage.editComments.click();
        BrowserUtils.waitFor(2);

        activityTaskValidationPage.textBox.clear();
        //insert comments  "Budget for Q4". this data will be taken
        // from feature file from feature file ActivityTabAndTaskValidation.feature
        activityTaskValidationPage.textBox.sendKeys(budgetForQ4);
        BrowserUtils.waitFor(2);

        //click save button
        activityTaskValidationPage.saveTextBtn.click();
        BrowserUtils.waitFor(2);

    }

    // Step to validate that the updated description is displayed
    @Then("validate {string} in description now shows")
    public void validateInDescriptionNowShows(String budgetForQ4) {

        // using JavaScriptExecutor to click expand (>) button and see details box
        BrowserUtils.waitFor(5);
        js.executeScript("arguments[0].click();", activityTaskValidationPage.expandDetails2);
        BrowserUtils.waitFor(5);

        //get text from description box and assign to String str
        String str = activityTaskValidationPage.descriptionBox.getText();
        BrowserUtils.waitFor(2);

        //verify "Budget for Q4" is displayed in description box
        assertEquals("Description box is not having the expected text", str, budgetForQ4);

    }

}
