package com.todoist.tests.mobile.config;


@BrowserstackConfig.LoadPolicy(BrowserstackConfig.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:${env}.properties",
        })

public interface BrowserstackConfig extends org.aeonbits.owner.Config {

    @Key("baseURL")
    String baseUrl();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();
}
