Feature: Activity tab and task validation


  Background: Successful login with valid credentials
    Given the user is on the Salesforce login page
    When the user enters valid username and password
    And the user clicks the login button

  @test
  Scenario: manage activity tab and task validation
    Given user navigates to Url
    Then user should see both tasks displayed
    When I click the expand icon for the Create Budget Plan task
    Then Description section should be blank
    Then click dropdown and select Edit comments text "Budget for Q4"
    Then validate "Budget for Q4" in description now shows








