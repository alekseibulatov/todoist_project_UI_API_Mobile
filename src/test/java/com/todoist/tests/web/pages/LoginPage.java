package com.todoist.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.todoist.tests.web.tests.WebTestData.*;

public class LoginPage {

    private SelenideElement
            headerLoginPage = $("._71a1610c"),
            setEmailField = $("#element-0"),
            setPasswordField = $("#element-3"),
            buttonLogin = $("[data-gtm-id=start-email-login]"),
            googleButton = $("[data-gtm-id=\"google-provider-link\"]"),
            headingGoogle = $("#headingText"),
            attentionElement = $("#element-2");

    @Step("Открываем страницу Login    по ссылке https://todoist.com/auth/login")
    public LoginPage openLoginPage() {
        open("/auth/login");

        return this;
    }

    @Step("Проверяем открытие страницы Login при клике на кнопку Войти")
    public LoginPage verificationOpenLoginPage() {
        headerLoginPage.shouldHave(text(entranceButton));

        return this;
    }

    @Step("Заполняем поле Email значением {value}")
    public LoginPage setEmail(String value) {
        setEmailField.setValue(value);

        return this;
    }

    @Step("Заполняем поле Password значением {value}")
    public LoginPage setPassword(String value) {
        setPasswordField.setValue(value);

        return this;
    }

    @Step("Кликаем по кнопке Войти на странице авторизации")
    public LoginPage clickToButtonLogin() {
        buttonLogin.click();
        sleep(15000);

        return this;
    }

    @Step("Кликаем на поле 'Продолжить через Google'")
    public LoginPage clickToGoogleButton() {
        googleButton.click();

        return this;
    }

    @Step("Проверяем переход по ссылке на сайт Google с формой авторизации")
    public LoginPage verificationOpenGooglePage() {
        headingGoogle.shouldHave(text(entranceGoogle));

        return this;
    }

    @Step("Проверяем наличие предупреждения 'Пожалуйста, введите действующий Email-адрес.' при пустых значениях в полях Email и Password")
    public LoginPage checkWhenEmptyLoginField() {
        attentionElement.shouldHave(text(attentionText));

        return this;
    }
}

