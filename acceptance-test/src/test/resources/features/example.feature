@DamService
Feature: User would like to get damServices

  Scenario: User should be able to get all damServices
    Given the following damServices exists in the library
      | description                 |
      | Twinkle twinkle little star |
    When user requests for all damServices
    Then the user gets the following damServices
      | description                 |
      | Twinkle twinkle little star |
