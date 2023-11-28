Feature: Orders Management

  Scenario: places a new order
    Given they choose Place Order
    When product name is "miror"
    Then the order should be placed successfully

  Scenario: lists orders
    Given they choose List Orders
    Then they should see a list of placed orders

  Scenario: lists categories in orders
    Given they choose List Categories
    Then they should see a list of available product categories
