@negative
Feature: CheckSignUpWithInvalidPassword

  Scenario: CheckSignUpWithInvalidPassword
    Given User get browser as chrome
    Given User open 'iqoption.com' page
    Given User set language as 'Русский'

    When User click on 'Регистрация'
    When User click on 'Окно регистрации'
    And User set text '**random_string**' in 'Имя' field
    And User set text '**random_string**' in 'Фамилия' field
    And User set text '**random_string**' in 'E-mail' field
    And User set text 'aD12' in 'Пароль' field

    When User click on 'Я принимаю «Положения и условия» и подтверждаю, что мне 18 лет или больше.'
    When User click on 'Открыть счет бесплатно'
    Then User see message text 'Пароль должен быть длиной не менее 6 символов и содержать хотя бы 1 букву и 1 цифру' on field 'Неверный пароль'
