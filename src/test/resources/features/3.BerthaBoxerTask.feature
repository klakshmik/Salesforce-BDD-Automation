Feature: Lead Interaction and Task Creation

  Background: Successful login with valid credentials
    Given the user is on the Salesforce login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be redirected to the Salesforce dashboard

  @test
  Scenario: Create tasks for the lead Bertha Boxer
    Given the user on the the My Leads view
    When user clicks on the lead named Bertha Boxer
    Then user should see her record open
    And user navigate to the Activity tab
    And user clicks on New Task
    And user creates a task  inserts value to Subject field "Create Budget Plan"
    And inserts value to box Due Date put value One week from today
    Then leave box Related to blank
    And  value Assigned to box should be populated if not select any user
    And select to Status box value "In Progress" and save
    Then user should see a popup notification confirming the task is created

    And user clicks on New Task
    And user creates a task  inserts value to Subject field "Submit Budget Plan for Review"
    And inserts value to box Due Date put value One week from today
    Then leave box Related to blank
    And  value Assigned to box should be populated if not select any user
    And select to Status box value "Not Started" and click save
    Then user should see a popup notification confirming the task is created





