package com.todoist.tests.mobile.config;

import org.aeonbits.owner.Config;

@EmulatorConfig.LoadPolicy(EmulatorConfig.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:emulator.properties"
})

public interface EmulatorConfig extends Config {


    @Key("deviceName")
    @DefaultValue("android")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("appPath")
    String appPath();

    @Key("remoteURL")
    String remoteURL();


    @Key("appURL")
    String appURL();
}
