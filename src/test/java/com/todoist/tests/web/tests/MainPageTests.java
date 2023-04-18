package com.todoist.tests.web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

/**
 * @author alekseibulatov (Aleksei Bulatov)
 *
 */

@Feature("MainPage")
@DisplayName("Тестирование главной страницы")
@Tag("Web")
public class MainPageTests extends WebTestBase {

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Главная страница сайта загружена ")
    @Tags ({@Tag("ui"), @Tag("smoke")})
    void currentOpenMainPageTest() {
        mainPage.openPage()
                .verificationMainPage();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("В шапке на главной странице отображаются ссылки 'Возможности, Шаблоны, Для команд," +
            "Ресурсы, Тарифы, Войти, Начать бесплатно'")
    @Tags ({@Tag("ui"), @Tag("smoke")})
    void verificationHeaderMainPageTest() {
        mainPage.openPage()
                .verificationHeaderMainPage();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("При клике на 'Тарифы' происходит переход на страницу с тарифами")
    @Tags ({@Tag("ui"), @Tag("smoke")})
    void openPricingPageWhenClickPriceTest() {
        mainPage.openPage()
                .openPricingPage();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("При клике на 'Войти' переходим на страницу Войти")
    @Tags ({@Tag("ui"), @Tag("smoke")})
    void openLoginPageWhenClickLoginTest() {
        mainPage.openPage()
                .openLoginPage();
        loginPage.verificationOpenLoginPage();

    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("При клике на 'Начать бесплатно' переходим на страницу Регистрации")
    @Tags ({@Tag("ui"), @Tag("smoke")})
    void openSignupPageWhenClickSignupTest() {
        mainPage.openPage()
                .openSignupPage();
        signupPage.verificationOpenSignupPage();
    }
}
