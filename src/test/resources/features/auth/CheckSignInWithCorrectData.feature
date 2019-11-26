@positive
Feature: CheckSignInWithCorrectData

  Scenario: CheckSignInWithCorrectData
    Given User get browser as chrome
    Given User open 'iqoption.com' page
    Given User set language as 'Русский'

    When User click on 'Войти'
    When User click on 'Mail.ru'
    And User set text 'iqoptiontest94' in 'Логин на стороне Mail.ru' field
    And User set text 'Qw01Option' in 'Пароль на стороне Mail.ru' field

    When User click on 'Войти и разрешить на стороне Mail.ru'
    Then User see field with value where:
      | Field               | Value                 |
      | Имя пользователя    | Test Sets             |
      | E-mail пользователя | iqoptiontest94@mail.ru|
