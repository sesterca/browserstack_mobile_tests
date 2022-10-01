# Тестирование мобильного приложения Wikipedia
[<img src="image/Wikipedia-logo.png">](https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk) *Добро пожаловать в Википедию, свободную энциклопедию, которую может редактировать каждый. [(c)](https://ru.wikipedia.org/wiki).* 


### В проекте протестировано :mag_right:
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
-DdeviceHost=${host}
```
[Пример сборки](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website/13/)
Открыть [Jenkins](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website), в меню слева выбрать ```Собрать с параметрами```

## Для просмотра отчета
Под названием проекта кликнуть [<img src="image/Allure_Report.svg" width="50">](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website/allure/)
#### Главный экран отчета
<img src="image/allure trend.jpg">

#### Экран подробного просмотра тестов тест-сьюта
<img src="image/allure tests.jpg">

#### Пример выполнения теста
![test_pass](https://user-images.githubusercontent.com/71780020/173231412-7821c04d-3a8f-4513-bd02-c8eaa5179f64.gif)

## Для уведомления о результатах тестирования
<img src="image/telegram report.jpg">
