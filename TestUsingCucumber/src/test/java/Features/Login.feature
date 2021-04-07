
Feature: Login in SmartBusiness
  

  Scenario: Login Using Valid Credentials
    Given User is on Landing login Page
    When User login into With Username and Password
    And Counter is selected
    Then Homepage is populated
    And Search Box is displaying