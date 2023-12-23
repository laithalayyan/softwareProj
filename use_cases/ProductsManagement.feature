Feature: Products Management

  Scenario : choose from list
    Given they have choices :Add Product or Delete Product or List Products or Back
    When they choose AddProduct
    And they choose DeleteProduct
    And they choose ListProducts
    And they choose Back
    Then successfulyy done

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

  Scenario: adds a product existed
    Given they choose Add Product
    When productt name is "miror"
    And product price is 20
    And product category is "miror"
    And product amount is 20
    Then the product should not be added

  Scenario: deletes a product
    Given they choose Delete Product
    When product to delete name is "miror"
    Then the product should be removed successfully

  Scenario: deletes a product not existed
    Given they choose Delete Product
    When product to delete name is "miror"
    Then the product should not be removed

  Scenario: lists products
    Given they choose List Products
    Then they should see a list of available products
