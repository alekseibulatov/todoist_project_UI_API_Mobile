package com.todoist.config;


import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {

    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void config() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.reportsUrl = config.videoUrl();
        MutableCapabilities capabilities = new DesiredCapabilities();
        if (config.isRemote()) {
            Configuration.remote = config.getSelenoidUrl();

           // DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
          //  Configuration.browserCapabilities = capabilities;
            //setChromeOptions(capabilities);
        }
        switch (config.getBrowser()) {
            case "chrome":
                setChromeOptions(capabilities);
                break;

            default:
                Configuration.browserCapabilities = capabilities;
        }

    }
    public static void setChromeOptions(MutableCapabilities capabilities) {
        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--no-sandbox")
                .addArguments("--disable-infobars")
                .addArguments("--disable-popup-blocking")
                .addArguments("--disable-notifications")
                .addArguments("--lang=ru")
                .setExperimentalOption("excludeSwitches", new String[]{"enable-automation"})
                .merge(capabilities);
    }
}
