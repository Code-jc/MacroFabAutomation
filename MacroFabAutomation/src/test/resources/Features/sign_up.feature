#Author: carlos.vlz@outlook.com

Feature: As a new user, I want to create an account on the MacroFab website so that I can access MacroFab’s products and services.

  Scenario: Sign up as a new user at MicoFab website 
    Given I don’t have a MacroFab account and I am on the MacroFab website
    When I sign up as a new user
    Then I am directed to the MacroFab dashboard page
    And I verify that I have no PCB orders
    And I verify I have no outbound shipments
    And I verify I have no inbound shipments
    And I verify I have no inventory
