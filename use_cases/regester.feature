Feature: user signs up

  Scenario: user sign up successfully
    Given that the user is not signed up
    When  email is "laith@gmail.com"
    And password is "123"
    And username is "laith"
    And type is "customer"
    Then the user will sign up and added to userslist


  Scenario: user failed to sign up
    Given that the user is not signed up
    When  email is "laith1@gmail.com"
    And password is "123"
    And username is "laith1"
    And type is "customer"
    Then the user will not sign up
    And show why can't sign up
