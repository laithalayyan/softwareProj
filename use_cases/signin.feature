Feature: Sign In

  Scenario: Successful sign-in
    Given I am on the sign-in page
    When emaill is "admin@admin.com"
    And passwordd is "123"
    Then I should be redirected to the dashboard

  Scenario: Unsuccessful sign-in
    Given I am on the sign-in page
    When  emaill is "laith1@gmail.com"
    And passwordd is "123"
    Then I should see an error message
