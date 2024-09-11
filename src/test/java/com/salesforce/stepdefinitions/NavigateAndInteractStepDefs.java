package com.salesforce.stepdefinitions;

import com.salesforce.pages.HomePage;
import com.salesforce.utilities.BrowserUtils;
import com.salesforce.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigateAndInteractStepDefs {

    // Initialize page object, home page link, and WebDriver instance

    //Pages classes we're using to store all located WebElements in one place and if we need we call them from there
    //We can find them in pages folder for each page separate, also we can manage, update,delete them in one place.
    HomePage homePage = new HomePage();
    String homePageLink = "https://sitetracker-1a-dev-ed.develop.lightning.force.com/lightning/setup/SetupOneHome/home";
    WebDriver driver = Driver.getDriver();

    @When("the user navigates to the Home page")
    public void the_user_navigates_to_the_home_page() {

        //navigates to Home page
        driver.get(homePageLink);
    }

    @And("the user opens the Apps menu and proceeds to the Leads section")
    public void the_user_opens_the_apps_menu_and_proceeds_to_the_section() {
        // Click on the App Launcher
        homePage.appLauncher.click();
        BrowserUtils.sleep(1); //Wait for 3 seconds

        // Enter "Leads" in the search field and press Enter
        homePage.inputAppLauncher.sendKeys("Leads" + Keys.ENTER);

        // Find and click on the "Leads" option
        WebElement lead = driver.findElement(By.xpath("//b[contains(text(),'Leads')]"));
        lead.click();
        BrowserUtils.waitFor(3); // Wait for 3 seconds for the Leads section to load
    }


    @When("the user ensures they are on the My Leads view")
    public void the_user_ensures_they_are_on_the_view() {
        // Click on the Leads object dropdown
        BrowserUtils.clickWithVisibilityCheck(homePage.leadsObjectDropdown);

        // Click on the "My Leads" option
        BrowserUtils.clickWithVisibilityCheck(homePage.myLeadsOption);

        BrowserUtils.waitFor(2);

        //Expected title for My Lead page
        String myLeadsTitleExpected = "Bertha Boxer | Lead | Salesforce";

        // Assert that the actual title matches the expected title of My Leads page
        Assert.assertEquals("You are not on the My Leads view", driver.getTitle(), myLeadsTitleExpected);

    }

    @When("the user clicks on the Filter icon")
    public void the_user_clicks_on_the_filter_icon() {

        BrowserUtils.clickWithVisibilityCheck(homePage.filtersButton);

    }

    @When("the user sets Created Date to a custom range")
    public void the_user_sets_to_a_custom_range() {

        // Click on the Created Date button
        BrowserUtils.clickWithVisibilityCheck(homePage.createdDateButton);

        //creating Date variable that will be inserted
        String dateInsert = "01/01/2024";

        // Clear any existing date value
        homePage.insertValueOfDate.clear();
        BrowserUtils.waitFor(2);

        // Enter the custom date and press Enter
        homePage.insertValueOfDate.sendKeys(dateInsert + Keys.ENTER);
        BrowserUtils.waitFor(2);

        // Click on the Done button to save the filter
        homePage.buttonDone.click();
        BrowserUtils.waitFor(2);

    }

    @When("the user saves the filter")
    public void the_user_saves_the_filter() {
        // Click on the Save button to save data
        BrowserUtils.clickWithVisibilityCheck(homePage.saveButton);

    }

    @Then("the user validates that the filter has been applied correctly")
    public void the_user_validates_that_the_filter_has_been_applied_correctly() {

        // Define the expected leads count
        String leadsCountExpected = "22 items";

        // Get the actual text displaying the number of leads
        BrowserUtils.waitFor(3);
        String text = homePage.myLeadsNumbersText.getText();
        BrowserUtils.waitFor(3);

        // Assert that the displayed count matches the expected count
        Assert.assertTrue("Leads count is not matching as expected", text.contains(leadsCountExpected));
        BrowserUtils.waitFor(2);
    }


}
