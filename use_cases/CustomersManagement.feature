Feature: Customers Management


  Scenario: registers a new customer
    Given they choose Register Customer
    When customer username is "laith"
    And customer email is "laith@gmail.com"
    And customer password is "123"
    And customer2 username is "laith2"
    And customer2 email is "laith2@gmail.com"
    And customer2 password is "123"
    Then the customers should be registered successfully

  Scenario: register a existed customer
    Given they choose Register Customer
    When customerr username is "laith"
    And customerr email is "laith@gmail.com"
    And customerr password is "123"
    Then the customers should not be registered

  Scenario: lists customers
    Given they choose List Customers
    Then they should see a list of registered customers
