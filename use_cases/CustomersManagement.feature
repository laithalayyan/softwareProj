Feature: Customers Management

  Scenario : choose from list
    Given they have choices :Register Customer or List Customers or Back
    When they choose Registerr Customer
    And they choose Listt Customers
    And they choose Backk
    Then successfulyyy done

  Scenario: registers a new customer
    Given they choose Register Customer
    When customer username is "laith"
    And customer email is "laith@gmail.com"
    And customer password is "123"
    And customer2 username is "laith2"
    And customer2 email is "laith2@gmail.com"
    And customer2 password is "123"
    Then the customers should be registered successfully

  Scenario: lists customers
    Given they choose List Customers
    Then they should see a list of registered customers
