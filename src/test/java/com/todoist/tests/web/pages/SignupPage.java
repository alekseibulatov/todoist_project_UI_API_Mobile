package com.todoist.tests.web.pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.todoist.tests.web.tests.WebTestData.headerTextSignupPage;

public class SignupPage {

    private SelenideElement headerSignupPage = $("._71a1610c");

    @Step("Проверяем открытие страницы Auth при клике на кнопку Начать бесплатно")
    public SignupPage verificationOpenSignupPage() {
        headerSignupPage.shouldHave(text(headerTextSignupPage));

        return this;
    }
}
