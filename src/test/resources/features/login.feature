@tag
Feature: Login functionality for SalesforceDev

  As a user of salesforce
  I want to be able to login into my account
  So that I can access my account related functionality
  As well as Manage my sales account

  Background:
    Given I am on the Saleforce login page

  @tag1
  Scenario: Successful Login With Valid credentials
    Given I have entered a valid Username and password
    When I click on the login button
    Then I should be logged in successfully

  @tag2
  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered an invalid "<Username>" and "<Password>"
    When I click on the login button
    Then I should see an error message indicated "invalid username or password"

    Examples: 
      | Username                     | Password | status  |
      | joshy96@urctech.com         | Jshy1T@ | success |
      | princejosh96-qs1n@force.com  | Joshy1   | Fail    |

  @tag3
  Scenario: Navigating to forgotten password page
    When I click on the "Forgotten password" Link
    Then I should be redirected to the password reset page
