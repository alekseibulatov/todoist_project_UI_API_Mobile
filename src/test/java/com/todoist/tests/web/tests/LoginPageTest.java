package com.todoist.tests.web.tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends WebTestBase {

    @Test
    @DisplayName("Успешное логгирование")
    @Tag("UI")
    void successLoginOnLoginPageTest() {
        loginPage.openLoginPage()
                .verificationOpenLoginPage()
                .setEmail("search23search@gmail.com")
                .setPassword("123!45678")
                .ClickToButtonLogin();

        todayPage.verificationSuccessLoginOnTodayPage();
    }

    @Test
    @DisplayName("Неудачное логгирование")
    @Tag("UI")
    void unsuccessfulLoginOnLoginPageTest() {
        loginPage.openLoginPage()
                .verificationOpenLoginPage()
                .setEmail("")
                .setPassword("")
                .ClickToButtonLogin()
                .checkWhenEmptyLoginField();
    }

    @Test
    @DisplayName("Проверка перехода по ссылке Гугл")
    @Tag("UI")
    void switchToGoogleTest() {
        loginPage.openLoginPage()
                .clickToGoogleButton()
                .verificationOpenGooglePage();
    }
}
