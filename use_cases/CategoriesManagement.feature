Feature: Admin Manage Categories

  Scenario: Admin adds a new category
    Given they choose Add Category
    When Category name is "interior"
    And Category2 name is "miror"
    Then the category should be added successfully

  Scenario: Admin deletes a category
    Given they choose Delete Category
    When Category name is "interior"
    Then the category should be removed successfully

  Scenario: Admin lists categories
    Given they choose List Categories
    Then they should see a list of available categories


