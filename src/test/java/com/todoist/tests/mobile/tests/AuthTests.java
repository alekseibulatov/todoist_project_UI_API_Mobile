package com.todoist.tests.mobile.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class AuthTests extends TestBase {

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
