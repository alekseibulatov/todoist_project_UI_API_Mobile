package com.todoist.tests.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.todoist.tests.mobile.driver.BrowserstackDriver;
import com.todoist.tests.mobile.driver.MobileDriver;
import com.todoist.tests.mobile.helpers.Attach;
import com.todoist.tests.mobile.pages.AuthPage;
import com.todoist.tests.mobile.pages.MainPage;
import com.todoist.tests.web.configWeb.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.SessionId;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();


    public static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAll() {
        String deviceHost = System.getProperty("deviceHost");
        switch (deviceHost) {
            case "android":
            case "ios":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "emulator":
                Configuration.browser = MobileDriver.class.getName();
                break;
            default:
                throw new RuntimeException(
                        "Invalid value for 'deviceHost'. Valid values are: android / ios / emulator "
                );
        }
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 30000;
        Configuration.browserSize = null;

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String deviceHost = System.getProperty("deviceHost");
        SessionId sessionId = Selenide.sessionId();

        closeWebDriver();

        if (deviceHost.equals("android")) {
            Attach.addVideo(sessionId.toString());
        }
    }
}
