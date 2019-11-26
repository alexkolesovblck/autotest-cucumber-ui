@negative
Feature: CheckSignUpWithInvalidFirstName

  Scenario Outline: CheckSignUpWithInvalidFirstName
    Given User get browser as <browser>
    Given User open 'iqoption.com' page
    Given User set language as 'Русский'

    When User click on 'Регистрация'
    When User click on 'Окно регистрации'
    And User set text '**random_string**' in 'Фамилия' field
    And User set text '**random_string**' in 'E-mail' field
    And User set text '**random_password**' in 'Пароль' field

    When User click on 'Я принимаю «Положения и условия» и подтверждаю, что мне 18 лет или больше.'
    When User click on 'Открыть счет бесплатно'
    Then User see message text 'Поле не заполнено' on field 'Поле не заполнено'

    Examples:
      | browser | email                  |
      | chrome  | iqoptiontest94@mail.ru |
      #| opera   | iqoptiontest94@mail.ru |
