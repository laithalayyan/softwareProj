Feature: Sign In

  Scenario: Login as admin
    Given admin is not logged in
    When Admin eemail is "admin@admin.com"
    And Admin ppassword is "123"
    Then the admin login

  Scenario: Login as Customer
    Given customer is not logged in
    When Customer eemail is "customer@customer.com"
    And Customer ppassword is "123"
    Then the customer login

  Scenario: Login as Installer
    Given installer is not logged in
    When Installer eemail is "installer@installer.com"
    And Installer ppassword is "123"
    Then the installer login
