Feature: Admin Appointments Management

  Scenario: Admin schedules a new appointment
    Given admin choose Schedule Appointment
    When car model is "toyota"
    And car date is "2012"
    Then Available Installers will be shown
    When installer number is "1"
    And appointment date is "22/12/2023"
    Then the appointment should be scheduled successfully

  Scenario: Admin lists appointments
    Given admin choose List Appointments
    Then they should see a list of scheduled appointments
