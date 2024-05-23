# О проекте

Проект по автоматизации тестирования Wikipedia представляет собой набор автотестов, написанных на языке Java с использованием фреймворков JUnit 5 и Allure. Для сборки проекта и запуска тестов используется инструмент сборки Gradle. Для непрерывной интеграции и автоматизации сборки, тестирования и развертывания программного обеспечения используются серверы Jenkins и GitLab CI/CD.

## Содержание

* [Технологии и инструменты](#технологии-и-инструменты)
* [Запуск тестов](#запуск-тестов)

## Технологии и инструменты

<p>  
<a href="https://www.jetbrains.com/idea/"><img src="https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.png" width="50" height="50" alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="https://www.vectorlogo.zone/logos/java/java-icon.svg" width="50" height="50" alt="Java"/></a>  
<a href="https://gradle.org/"><img src="https://www.vectorlogo.zone/logos/gradle/gradle-icon.svg" width="50" height="50" alt="Gradle"/></a>
<a href="https://junit.org/junit5/"><img src="https://junit.org/junit5/assets/img/junit5-logo.png" width="50" height="50" alt="JUnit 5"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="50" height="50" alt="Allure"/></a> 
<a href="https://www.jenkins.io/"><img src="https://www.jenkins.io/images/logos/jenkins/jenkins.svg" width="50" height="50" alt="Jenkins"/></a>  
<a href="https://web.telegram.org/"><img src="https://upload.wikimedia.org/wikipedia/commons/8/82/Telegram_logo.svg" width="50" height="50" alt="Telegram"/></a>  
<a href="https://developer.android.com/studio"><img src="https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/android-studio-icon.svg" width="50" height="50" alt="Android Studio"/></a>
<a href="https://www.browserstack.com/"><img src="https://cdn.worldvectorlogo.com/logos/browserstack.svg" width="50" height="50" alt="BrowserStack"/></a>
<a href="https://appium.io/"><img src="https://cdn.worldvectorlogo.com/logos/appium.svg" width="50" height="50" alt="Appium"/></a>
</p>


- [IntelliJ IDEA](https://www.jetbrains.com/idea/): IDE для разработки на Java.
- [Java](https://www.java.com/): Язык программирования, используемый для разработки приложения.
- [Gradle](https://gradle.org/): Инструмент сборки проекта.
- [JUnit 5](https://junit.org/junit5/): Фреймворк для тестирования Java-приложений.
- [Allure](https://github.com/allure-framework/allure2): Фреймворк для создания отчетов о результатах тестирования.
- [Jenkins](https://www.jenkins.io/): Сервер непрерывной интеграции для автоматизации сборки, тестирования и развертывания программного обеспечения.
- [Telegram](https://web.telegram.org/): Уведомления о результатах тестирования.
- [Android Studio](https://developer.android.com/studio): IDE для разработки приложений под Android.
- [BrowserStack](https://www.browserstack.com/): Платформа для тестирования веб-приложений в различных браузерах и на различных устройствах.
- [Appium](https://appium.io/): Инструмент для автоматизированного тестирования мобильных приложений.

## Запуск тестов


`gradle clean test`: Запуск всех доступных тестов.

`gradle clean mobile_test`: Запуск мобильных тестов.

`gradle clean api_test`: Запуск API-тестов.

`gradle clean web_test`: Запуск тестов веб-интерфейса.

## Конфигурация тестов

Конфигурация осуществляется через .properties файлы в `src/test/resources.config` или через системные переменные.
Для этого используется библиотека Owner

<details>
  <summary>Переменные для Web тестов:</summary>

```bash
-Dbase.url=https://ru.wikipedia.org
-DbrowserName=firefox
-Dbrowser.version=124
-Dbrowser.size=1920x1080
-DselenoidUrl=http://example:4444
```
</details>

<details>
  <summary>Переменные для browserstack:</summary>

```bash
-Dexecution.platform=browserstack
-Dplatform=android

-Dbrowserstack.url=http://hub.browserstack.com/wd/hub
-Dbrowserstack.username=username
-Dbrowserstack.accessKey=accessKey

-Dapp.url=bs://0cd3ce2cc92d09da9e3ca001b10074f2093aa04c
-Ddevice.name=Samsung Galaxy S22 Ultra
-Ddevice.os_version=12.0
```
</details>

<details>
  <summary>Переменные для android studio эмулятора:</summary>

```bash
-Dexecution.platform=emulator
-Demulator.url=http://127.0.0.1:4723
-Ddevice.name=Pixel_5_API_26
-Ddevice.version=8.0
-Dapp.url=bs://sample.app
```
</details>



<details>
  <summary>Переменные для api тестов:</summary>

```bash
-Dbase.url=https://ru.wikipedia.org
```
</details>


