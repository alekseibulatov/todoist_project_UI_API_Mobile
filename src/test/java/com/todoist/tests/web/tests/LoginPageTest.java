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
 */

@Feature("LoginPage")
@DisplayName("Тестирование страницы авторизации")
public class LoginPageTest extends WebTestBase {

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Авторизация на сайте  с корректным логином и паролем")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void successLoginOnLoginPageTest() {
        loginPage.openLoginPage()
                .verificationOpenLoginPage()
                .setEmail(credentialsConfig.login())
                .setPassword(credentialsConfig.password())
                .clickToButtonLogin();


        todayPage.closeTab();

        todayPage.verificationSuccessLoginOnTodayPage();

        todayPage.loginOut();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Авторизация на сайте без ввода логина и пароля")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void unsuccessfulLoginOnLoginPageTest() {
        loginPage.openLoginPage()
                .verificationOpenLoginPage()
                .setEmail("")
                .setPassword("")
                .clickToButtonLogin()
                .checkWhenEmptyLoginField();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода по ссылке Гугл на странице авторизации")
    @Tags({@Tag("ui"), @Tag("smoke")})
    void switchToGoogleTest() {
        loginPage.openLoginPage()
                .clickToGoogleButton()
                .verificationOpenGooglePage();
    }
}
