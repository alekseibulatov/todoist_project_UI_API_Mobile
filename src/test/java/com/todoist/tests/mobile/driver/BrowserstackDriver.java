package com.todoist.tests.mobile.driver;

import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static com.todoist.tests.mobile.config.ConfigReader.authConfig;
import static com.todoist.tests.mobile.config.ConfigReader.browserstackConfig;

public class BrowserstackDriver implements WebDriverProvider {

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