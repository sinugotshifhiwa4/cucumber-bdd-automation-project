#Author Tshifhiwa Sinugo
# Project:  Log in to OrangeHRM, navigate to the dashboard, go to admin, add a new user, fill all fields, and click save
# Date 27/07/2024

Feature: OrangeHRM Login and Add User Feature

  Background: User must log in
    Given User is on the OrangeHRM login page
    When User enters username and password and clicks the login button
    Then User is navigated to the OrangeHRM dashboard

  @addUser
  Scenario: Add a new user in OrangeHRM
    Given User is on the OrangeHRM dashboard
    When User navigates to the Admin tab
    And User clicks the Add button
    And User fills in all required fields
    And User clicks the Save button
    Then User should see a confirmation message indicating the user has been added successfully


