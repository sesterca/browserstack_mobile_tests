# Тестирование мобильного приложения Wikipedia
[<img src="image/Wikipedia-logo.png">](https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk) 

*Добро пожаловать в [Википедию](https://ru.wikipedia.org/wiki), свободную энциклопедию, которую может редактировать каждый.* 


### В проекте реализована :mag_right:
* Проверка текста экранов приветствия
* Проверка загрузки изображений экранах приветствия
* Проверка поиска по статьям
* Проверка показа капчи при регистрации
* Проверка видимости пароля после тапа на значок глаза
* Проверка авторизации
* Проверка добавления русского языка
* Проверка поиска языка в справочнике

### В проекте использованы :gear:
<img src="image/Browserstack.svg" width="60"><img src="image/Appium.svg" width="60"><img src="image/Java.svg" width="60"><img src="image/Gradle.svg" width="60"><img src="image/Intelij_IDEA.svg" width="60"><img src="image/Selenide.svg" width="60"><img src="image/GitHub.svg" width="60"><img src="image/Jenkins.svg" width="60"><img src="image/Allure_Report.svg" width="60"><img src="image/Telegram.svg" width="60">

## Для запуска тестов
### локально в терминале :computer:
```
gradle clean test -DdeviceHost=emulation
```
### удаленно в Jenkins :desktop_computer:
```
gradle clean test
-DdeviceHost=browserstack
```
[Пример сборки](https://jenkins.autotests.cloud/job/012-sesterca-u21-browserstack_mobile_tests/35/)
Открыть [Jenkins](https://jenkins.autotests.cloud/job/012-sesterca-u21-browserstack_mobile_tests/), в меню слева выбрать ```Собрать с параметрами```

#### Главный экран отчета Browserstack
<img src="image/browserstack_screenshot.jpg">
<img src="image/browserstack_app_profiling.jpg">

## Для просмотра отчета
Под названием проекта кликнуть [<img src="image/Allure_Report.svg" width="15">](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website/allure/)

#### Экраны просмотра отчета о прохождении тестов Allure
<img src="image/Browserstack_allure_main.jpg">
<img src="image/Browserstack_allure_suitcase.jpg">

#### Пример выполнения теста
<img src="image/browserstack_add_language.gif">

## Для уведомления о результатах тестирования
<img src="image/Browserstack_telegram_notification.jpg">
