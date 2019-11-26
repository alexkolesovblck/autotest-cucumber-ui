@positive
Feature: CheckSignInWithCorrectDataOpera

  Scenario: CheckSignInWithCorrectDataOpera
    Given User get browser as opera
    Given User open 'iqoption.com' page
    Given User set language as 'Русский'
    Then User see field with value where:
      | Field               | Value                  |
      | Начать торговать    | Начать торговать2      |
      | Учебный счет        | Учебный счет1          |