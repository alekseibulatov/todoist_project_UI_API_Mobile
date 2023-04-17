package com.todoist.tests.mobile.driver;

import com.codeborne.selenide.WebDriverProvider;
import com.todoist.tests.mobile.config.AuthConfig;
import com.todoist.tests.mobile.config.BrowserstackConfig;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);


        mutableCapabilities.setCapability("browserstack.user", authConfig.login());
        mutableCapabilities.setCapability("browserstack.key", authConfig.password());


        mutableCapabilities.setCapability("app", browserstackConfig.appUrl());


        mutableCapabilities.setCapability("device", browserstackConfig.device());
        mutableCapabilities.setCapability("os_version", browserstackConfig.osVersion());


        mutableCapabilities.setCapability("project", browserstackConfig.projectName());
        mutableCapabilities.setCapability("build", browserstackConfig.buildName());
        mutableCapabilities.setCapability("name", browserstackConfig.testName());


        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserstackConfig.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}