Feature: Filter and display adjustments

  Background: Successful login with valid credentials
    Given the user is on the Salesforce login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be redirected to the Salesforce dashboard


  @test
    Scenario: Manage filters and view tasks
      And navigate to Url
      When user clicks gear icon next to Filters and set the date range to the next seven days and apply
      Then Validate that only the "Create Budget Plan" task is displayed only
      Then  click all Activities
      Then user should see both tasks displayed
