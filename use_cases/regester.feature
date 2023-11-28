Feature: user signs up

  Scenario: user sign up
    Given that the user is not signed up
    When  email is "laithhh@gmail.com"
    And password is "123"
    And username is "laith"
    And type is "customer"
    Then the user will sign up and added to userslist

  Scenario: user failed sign up
    Given that the user2 is not signed up
    When  email2 is "laithhh@gmail.com"
    And password2 is "123"
    And username2 is "laith"
    And type2 is "customer"
    Then the user2 will not signed up