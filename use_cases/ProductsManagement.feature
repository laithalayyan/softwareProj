Feature: Products Management

  Scenario: adds a new product
    Given they choose Add Product
    When productt name is "miror"
    And product price is 20
    And product category is "miror"
    And product amount is 20
    And product2 name is "tear"
    And product2 price is 200
    And product2 category is "tear"
    And product2 amount is 200
    Then the product should be added successfully

  Scenario: deletes a product
    Given they choose Delete Product
    When product to delete name is "miror"
    Then the product should be removed successfully

  Scenario: lists products
    Given they choose List Products
    Then they should see a list of available products
