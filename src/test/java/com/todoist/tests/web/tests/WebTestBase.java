package com.todoist.tests.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;


import com.todoist.tests.web.configWeb.CredentialsConfig;

import com.todoist.tests.web.drivers.WebDriverProvider;
import com.todoist.tests.web.helpersWeb.Attach;
import com.todoist.tests.web.pages.LoginPage;
import com.todoist.tests.web.pages.MainPage;
import com.todoist.tests.web.pages.SignupPage;
import com.todoist.tests.web.pages.TodayPage;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebTestBase {

    static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    TodayPage todayPage = new TodayPage();

    @Step("Выполняем настройку запуска")
    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();
        Configuration.pageLoadTimeout = 15000;
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
