@negative
Feature: CheckSignInWithIncorrectEmail

  Scenario: CheckSignInWithIncorrectEmail
    Given User get browser as chrome
    Given User open 'iqoption.com' page
    Given User set language as 'Русский'

    When User click on 'Войти'
    And User set text '**random_string**' in 'E-mail' field
    And User set text '**random_password**' in 'Пароль' field

    When User click on 'Авторизоваться'
    Then User see message text 'Неверный e-mail' on field 'Неверный e-mail'