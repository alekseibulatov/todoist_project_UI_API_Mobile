package com.todoist.tests.mobile.driver;

import com.codeborne.selenide.WebDriverProvider;
import com.todoist.tests.mobile.helpers.ApkInfoHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static com.todoist.tests.mobile.config.ConfigReader.emulatorConfig;
import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class MobileDriver implements WebDriverProvider {

    private static String APP_PACKAGE = emulatorConfig.appPackage();
    private static String APP_ACTIVITY = emulatorConfig.appActivity();

    public static URL getAppiumServerUrl() {
        try {
            return new URL(emulatorConfig.remoteURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    private void initPackageAndActivity() {

        ApkInfoHelper helper = new ApkInfoHelper();
        APP_PACKAGE = APP_PACKAGE.isEmpty() ? helper.getAppPackageFromApk() : APP_PACKAGE;
        APP_ACTIVITY = APP_ACTIVITY.isEmpty() ? helper.getAppMainActivity() : APP_ACTIVITY;
    }

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        initPackageAndActivity();
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(emulatorConfig.deviceName())
                .setPlatformVersion(emulatorConfig.platformVersion())
                .setApp(getAppPath())
                .setAppPackage(APP_PACKAGE)
                .setAppActivity(APP_ACTIVITY);


        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {

        File app = new File(emulatorConfig.appPath());
        if (!app.exists()) {
            try (InputStream in = new URL(emulatorConfig.appURL()).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}
