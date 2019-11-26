@positive
Feature: CheckSignInWithCorrectDataChrome

  Scenario: CheckSignInWithCorrectDataChrome
    Given User get browser as chrome
    Given User open 'iqoption.com' page
    Given User set language as 'Русский'
    Then User see field with value where:
      | Field               | Value                 |
      | Начать торговать    | Начать торговать2      |
      | Учебный счет | Учебный счет1          |