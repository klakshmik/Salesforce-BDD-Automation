package com.salesforce.stepdefinitions;

import com.salesforce.pages.LoginPage;
import com.salesforce.utilities.BrowserUtils;
import com.salesforce.utilities.ConfigurationReader;
import com.salesforce.utilities.Driver;
import com.salesforce.utilities.NotificationHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class LoginStepDefs {


    // Initialize page objects
    //Pages classes we're using to store all located WebElements in one place and if we need we call them from there
    //We can find them in pages folder for each page separate
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver(); // Assuming Driver is a utility class to manage WebDriver instances
    BrowserUtils browserUtils = new BrowserUtils(); // Initialize utilities class to call reusable methods from this class
    NotificationHandler notificationHandler = new NotificationHandler(driver);

    @Given("the user is on the Salesforce login page")
    public void the_user_is_on_the_salesforce_login_page() {

        // Define the Salesforce login page URL and expected title
        String URL_loginPage = "https://sitetracker-1a-dev-ed.develop.my.salesforce.com/";
        String expectedTitleOfLoginPage = "Login | Salesforce";

        // Navigate to the Salesforce login page
        driver.get(URL_loginPage);
        String title = driver.getTitle();

        // Assert that the user is on the expected login page
        Assert.assertEquals("User are not on the login page", title, expectedTitleOfLoginPage);
    }
    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {

        // Retrieve valid credentials from configuration
        String validUsername = ConfigurationReader.getProperty("username");
        String validPassword = ConfigurationReader.getProperty("password");
        System.out.println("Test Test Test!!!!!!!!!!!");

        // Enter valid username and password in the login page input fields
        loginPage.usernameInputBox.sendKeys(validUsername);
        loginPage.passwordInputBox.sendKeys(validPassword);

    }
    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {

        // Click on the login button
        loginPage.loginButton.click();
        // Wait for up to 3 seconds for the page to load
        browserUtils.waitFor(3);
    }

    @Then("the user should be redirected to the Salesforce dashboard")
    public void the_user_should_be_redirected_to_the_salesforce_dashboard() {

        // Define the expected title of the Salesforce dashboard page
        String expectedTitleOfHomePage = "Home | Salesforce";

        // Dismiss any notification pop-ups if present
        notificationHandler.dismissNotificationIfPresent();

        // Assert that the current page title contains the expected title for the dashboard
        Assert.assertTrue(driver.getTitle().contains(expectedTitleOfHomePage) );

    }
}
