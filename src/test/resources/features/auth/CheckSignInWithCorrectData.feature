@positive
Feature: CheckSignInWithCorrectData

  Scenario: CheckSignInWithCorrectData
    Given User get browser as chrome
    Given User open 'iqoption.com' page
    Given User set language as 'Русский'

    When User click on 'Войти'
    When User click on 'Mail.ru'
    And User set text '**user_login**' in 'Логин на стороне Mail.ru' field
    And User set text '**user_password**' in 'Пароль на стороне Mail.ru' field

    When User click on 'Войти и разрешить на стороне Mail.ru'
    Then User see field with value where:
      | Field               | Value                 |
      | Имя пользователя    | Test Sets             |
      | E-mail пользователя | **user_email**        |