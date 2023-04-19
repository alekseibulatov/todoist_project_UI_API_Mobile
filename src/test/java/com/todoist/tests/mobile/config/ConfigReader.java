package com.todoist.tests.mobile.config;

import org.aeonbits.owner.ConfigFactory;


public class ConfigReader {

    public static final EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class, System.getProperties());
    public static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);
}

