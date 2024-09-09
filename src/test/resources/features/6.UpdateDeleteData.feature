Feature:  Clean or Delete data for next test


  Background: Successful login with valid credentials
    Given the user is on the Salesforce login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be redirected to the Salesforce dashboard

  @test
  Scenario: manage data for next test
    Given user navigates to URL
    Then clicks dropdown of first task and delete data from upcoming tasks

