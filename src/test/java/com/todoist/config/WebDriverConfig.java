package com.todoist.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://todoist.com")
    String baseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("selenoidUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getSelenoidUrl();

    @Key("videoUrl")
    String videoUrl();

    @Key("isRemote")
    @DefaultValue("true")
    Boolean isRemote();
}
