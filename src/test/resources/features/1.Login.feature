Feature: Login Automation

@test
Scenario: Successful login with valid credentials
Given the user is on the Salesforce login page
When the user enters valid username and password
And the user clicks the login button
Then the user should be redirected to the Salesforce dashboard