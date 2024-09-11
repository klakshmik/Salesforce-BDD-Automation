package com.salesforce.stepdefinitions;

import com.salesforce.pages.BerthaBoxerTaskPage;
import com.salesforce.utilities.BrowserUtils;
import com.salesforce.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.salesforce.utilities.BrowserUtils.getDatePlusDays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BerthaBoxerTaskStepDef {

    // Initialize page object BerthaBoxerTaskPage, WebDriver instance, browserUtils, also url for My Leads
    WebDriver driver = Driver.getDriver();

    //Pages classes we're using to store all located WebElements in one place and if we need we call them from there
    //We can find them in pages folder for each page separate, also we can manage, update,delete them in one place.
    BerthaBoxerTaskPage BerthaBoxerTaskPage = new BerthaBoxerTaskPage();

    String urlMyLeads = "https://sitetracker-1a-dev-ed.develop.lightning.force.com/lightning/o/Lead/list?filterName=00Bak00000CDZFCEA5";

    @Given("the user on the the My Leads view")
    public void theUserOnTheTheMyLeadsView() {

        // Navigate to the My Leads page
        BrowserUtils.waitFor(2);
        driver.get(urlMyLeads);
        BrowserUtils.waitFor(2);

    }

    @When("user clicks on the lead named Bertha Boxer")
    public void user_clicks_on_the_lead_named() {

        // Locate the Bertha Boxer lead
        WebElement bertha = BerthaBoxerTaskPage.berthaNameInTable;

        // Click on the Bertha Boxer lead
        bertha.click();
        BrowserUtils.waitFor(2);

    }

    @Then("user should see her record open")
    public void user_should_see_her_record_open() {

        // Verify Bertha Boxer's record is open
        WebElement leadRecordElement = BerthaBoxerTaskPage.berthaRecord;
        assertTrue("Lead record page is not displayed", leadRecordElement.isDisplayed());
        BrowserUtils.waitFor(2);
    }


    @Then("user navigate to the Activity tab")
    public void user_navigate_to_the_tab() {

        // Click on the Activity tab
        BerthaBoxerTaskPage.activityTab.click();
        BrowserUtils.waitFor(3);
    }

    @Then("user clicks on New Task")
    public void user_click_on() {

        // Click on the New Task button
        BerthaBoxerTaskPage.newTaskButton.click();
        BrowserUtils.waitFor(2);
    }

    @And("user creates a task  inserts value to Subject field {string}")
    public void userCreatesATaskInsertsValueToBox(String subjectValue) {

        // Enter Subject value
        BerthaBoxerTaskPage.subjectField.sendKeys(Keys.BACK_SPACE + subjectValue);
    }

    @And("inserts value to box Due Date Today's date")
    public void insertsValueToBoxDueDate() {

        // Get today's date from  BrowserUtils class  getTodaysDate() method allows to get today`s date
        String todaysDate = BrowserUtils.getTodaysDate();

        // Enter today's date in the Due Date field
        BrowserUtils.waitFor(2);
        BerthaBoxerTaskPage.dueDateField.sendKeys(Keys.BACK_SPACE + todaysDate);

    }

    @Then("leave box Related to blank")
    public void leaveBoxRelatedToBlank() {

        //Get text from Related To  field
        String textRelatedField = BerthaBoxerTaskPage.relatedField.getText();

        // Clear the Related To field if not blank
        if (!textRelatedField.isBlank()) {
            BerthaBoxerTaskPage.relatedFieldDelete.click();
        }
    }

    @And("value Assigned to box should be populated if not select any user")
    public void valueAssignedToBoxShouldBePopulatedIfNotSelectAnyUser() {

        //get text from assigned to field and check if field is blank
        String textAssignedToField = BerthaBoxerTaskPage.assignedTo.getText();
        if (textAssignedToField.isBlank()) {

            // Select a default user if the Assigned To field is blank
            BrowserUtils.waitFor(2);
            BerthaBoxerTaskPage.assignedToChoseOne.click();
            BrowserUtils.waitFor(2);
        }
    }

    @And("select to Status box value {string} and save")
    public void selectToStatusBoxValueInProgress(String expectedStatus) {

        //click status field
        BerthaBoxerTaskPage.statusField.click();
        BrowserUtils.waitFor(2);

        // Select the status 'In Progress'
        BerthaBoxerTaskPage.statusFieldInProgress.click();

        // Get Text from status field and put to String variable actualStatus
        String actualStatus = BerthaBoxerTaskPage.statusField.getText();
        BrowserUtils.waitFor(2);

        // Verify the status actual and expected
        // expectedStatus this is parameter in our current method of this step connected with feature file BerthaBoxerTask.feature
        //this method using data from feature file :-> row  20.And select to Status box value "In Progress" and save
        assertEquals(actualStatus, expectedStatus);
        BrowserUtils.waitFor(2);

        // Click save
        BerthaBoxerTaskPage.saveButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("user should see a popup notification confirming the task is created")
    public void userShouldSeeAPopupNotificationConfirmingTheTaskIsCreated() {

        // Verify popup notification
        assertTrue(BerthaBoxerTaskPage.popupNotification.isDisplayed());
        BrowserUtils.waitFor(3);

        //Get text from popup notification
        String tex = BerthaBoxerTaskPage.popupNotification.getText();

    }

    @And("inserts value to box Due Date put value One week from today")
    public void insertsValueToBoxDueDatePutValue() {

        // Get the date one week from today
        String dateInOneWeek = getDatePlusDays(-8);    // method from BrowserUtils    getDatePlusDays()
        System.out.println("Date 1 week from today: " + dateInOneWeek);

        // Enter the date in the Due Date field
        BerthaBoxerTaskPage.dueDateField.sendKeys(Keys.BACK_SPACE + dateInOneWeek);
        BrowserUtils.waitFor(2);

    }

    @And("select to Status box value {string} and click save")
    public void selectToStatusBoxValueAndSave(String statusExpected) {


        //Click status field
        BerthaBoxerTaskPage.statusField.click();
        BrowserUtils.waitFor(2);

        // Select the status 'Not Started'
        BerthaBoxerTaskPage.statusNotStarted.click();
        String statusActual = BerthaBoxerTaskPage.statusField.getText();

        // Verify the status actual and expected
        // statusExpected we take from feature file that we assigned to this method
        assertEquals(statusActual, statusExpected);
        BrowserUtils.waitFor(2);

        //click save button
        BerthaBoxerTaskPage.saveButton.click();

    }


}
