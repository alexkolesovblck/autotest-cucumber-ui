@negative
Feature: CheckSignInWithIncorrectValidData

  Scenario Outline: CheckSignInWithIncorrectValidData
    Given User get browser as <browser>
    Given User open 'iqoption.com' page
    Given User set language as 'Русский'

    When User click on 'Войти'
    And User set text '**random_email**' in 'E-mail' field
    And User set text '**random_password**' in 'Пароль' field

    When User click on 'Авторизоваться'
    Then User see message text 'Неправильный логин или пароль' on field 'Ошибка входа'

    Examples:
      | browser | email                  |
      | chrome  | iqoptiontest94@mail.ru |
      #| opera   | iqoptiontest94@mail.ru |
