package com.todoist.tests.web.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.todoist.tests.web.tests.WebTestData.*;

public class MainPage {

    private SelenideElement
            headerMainPage = $(".Fr24eSsXxsj5au0pdZzA"),
            headingPricePage = $(".typography_heading2Xl__ryW_E");

    private ElementsCollection
            headerButton = $$(".yJmXDmy7f2C2dFexmqOR"),
            headerButtonAuth = $$(".cdc4_xoyu5lt350lFjqA");

   @Step("Открываем главную страницу сайта https://todoist.com/ru")
    public MainPage openPage() {
        open("/ru");

        return this;
    }

    @Step("Проверяем загрузку главной страницы")
    public MainPage verificationMainPage() {
        headerMainPage.shouldHave(text(headerTextMainPage));

        return this;
    }

    @Step("Проверяем наличие в header кнопок")
    public MainPage verificationHeaderMainPage() {
        headerButton.get(0).shouldHave(text(featuresButton));
        headerButton.get(1).shouldHave(text(templatesButton));
        headerButton.get(2).shouldHave(text(businessButton));
        headerButton.get(3).shouldHave(text(resourcesButton));
        headerButton.get(9).shouldHave(text(priceButton));
        headerButton.get(10).shouldHave(text(exitButton));
        headerButtonAuth.get(0).shouldHave(text(signUpButton));

        return this;
    }

    @Step("Проверяем открытие  страницы с Тарифами при клике на кнопку Тарифы")
    public MainPage openPricingPage() {
        headerButton.get(9).click();
        headingPricePage.shouldHave(text(titlePricePage));

        return this;
    }

    @Step("Кликаем  на кнопку Войти")
    public MainPage openLoginPage() {
        headerButton.get(10).click();

        return this;
    }

    @Step("Кликаем на кнопку Начать бесплатно")
    public MainPage openSignupPage() {
        headerButtonAuth.get(0).click();

        return this;
    }
}
