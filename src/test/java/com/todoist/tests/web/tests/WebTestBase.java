package com.todoist.tests.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.todoist.config.WebDriverProvider;
import com.todoist.helpers.Attach;
import com.todoist.tests.web.pages.LoginPage;
import com.todoist.tests.web.pages.MainPage;
import com.todoist.tests.web.pages.SignupPage;
import com.todoist.tests.web.pages.TodayPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;

public class WebTestBase {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    TodayPage todayPage = new TodayPage();

    @Step("Настройки запуска")
    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();
        Configuration.pageLoadTimeout = 45000;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Step("Загрузка Attachments")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}