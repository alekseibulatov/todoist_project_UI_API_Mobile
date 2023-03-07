package com.todoist.tests.web.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class MainPageTests extends WebTestBase {

    @Test
    @Tag("UI")
    void currentOpenMainPageTest() {
        mainPage.openPage()
                .verificationMainPage();
    }

    @Test
    @DisplayName("В шапке на главной странице отображаются ссылки ВОЗМОЖНОСТИ, ШАБЛОНЫ, ДЛЯ КОМАНД," +
            "РЕСУРСЫ, ТАРИФЫ, ВОЙТИ, НАЧАТЬ БКСПЛАТНО")
    @Tag("UI")
    void verificationHeaderMainPageTest() {
        mainPage.openPage()
                .verificationHeaderMainPage();
    }

    @Test
    @DisplayName("При клике на Тарифы происходит переход на страницу с тарифами")
    @Tag("UI")
    void openPricingPageWhenClickPriceTest() {
        mainPage.openPage()
                .openPricingPage();
    }

    @Test
    @DisplayName("При клике на Войти переходим на страницу Войти")
    @Tag("UI")
    void openLoginPageWhenClickLoginTest() {
        mainPage.openPage()
                .openLoginPage();
        loginPage.verificationOpenLoginPage();

    }

    @Test
    @DisplayName("При клике на Начать бесплатно переходим на страницу Регистрации")
    @Tag("UI")
    void openSignupPageWhenClickSignupTest() {
        mainPage.openPage()
                .openSignupPage();
        signupPage.verificationOpenSignupPage();
    }
}
