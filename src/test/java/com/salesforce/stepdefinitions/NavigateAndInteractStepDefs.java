package com.salesforce.stepdefinitions;

import com.salesforce.pages.HomePage;
import com.salesforce.utilities.BrowserUtils;
import com.salesforce.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

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
        BrowserUtils.sleep(2); // Wait for 2 seconds
    }

    @And("the user opens the Apps menu and proceeds to the Leads section")
    public void the_user_opens_the_apps_menu_and_proceeds_to_the_section() {

        // Click on the App Launcher
        homePage.appLauncher.click();
        BrowserUtils.sleep(3); //Wait for 3 seconds

        // Enter "Leads" in the search field and press Enter
        homePage.inputAppLauncher.sendKeys("Leads"+Keys.ENTER);

        // Find and click on the "Leads" option
         WebElement lead = driver.findElement(By.xpath("//b[contains(text(),'Leads')]"));
         lead.click();
         BrowserUtils.waitFor(3); // Wait for 3 seconds for the Leads section to load
    }


    @When("the user ensures they are on the My Leads view")
    public void the_user_ensures_they_are_on_the_view() {

        // Click on the Leads object dropdown
       homePage.leadsObjectDropdown.click();
       BrowserUtils.waitFor(3);

        // Click on the "My Leads" option
       homePage.myLeadsOption.click();
       BrowserUtils.waitFor(3);


       //Expected title for My Lead page
        String myLeadsTitleExpected = "Bertha Boxer | Lead | Salesforce";

        // Assert that the actual title matches the expected title of My Leads page
        Assert.assertTrue("You are not on the My Leads view",driver.getTitle().equals(myLeadsTitleExpected));
        BrowserUtils.waitFor(3);

    }
    @When("the user clicks on the Filter icon")
    public void the_user_clicks_on_the_filter_icon() {

        // Click on the filter icon
        homePage.filtersButton.click();
        BrowserUtils.waitFor(2);

    }
    @When("the user sets Created Date to a custom range")
    public void the_user_sets_to_a_custom_range() {

        // Click on the Created Date button
        homePage.createdDateButton.click();
        BrowserUtils.waitFor(2);

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
        homePage.saveButton.click();
        BrowserUtils.waitFor(4);

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
        Assert.assertTrue("Leads count is not matching as expected",text.contains(leadsCountExpected));
        BrowserUtils.waitFor(2);
    }






}
