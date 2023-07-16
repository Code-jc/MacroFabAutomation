#Author: carlos.vlz@outlook.com
Feature: As a user registered, I want to login into the MacroFab website.

  Scenario Outline: Log In Into the MicoFab website
    Given I have a MacroFab account and I am on the MacroFab website
    When I enter the email and password and click the Sign In button
    Then I am directed to the Dashboard page

    Examples: 
      | email               | password |
      | johnsmith2@macrofab | test01   |