package com.todoist.tests.mobile.tests;

import com.todoist.tests.mobile.pages.AuthPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class AuthTests extends TestBase {

    private static AuthPage authPage;

    @BeforeAll
    public static void init() {
        authPage = new AuthPage();
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешная авторизация пользователя")
    @Tags({@Tag("Mobile"), @Tag("smoke")})
    public void successfulLogin() {
        authPage.clickToButtonMoreOptions()
                .clickToButtonLoginWithEmail()
                .setValueEmailGoogle()
                .setValueEmailGoogle()
                .clickToSLoginButton();

    }
}
