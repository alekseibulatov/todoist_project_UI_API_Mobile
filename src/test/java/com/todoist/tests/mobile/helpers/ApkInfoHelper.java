package com.todoist.tests.mobile.helpers;

import com.todoist.tests.mobile.config.ConfigReader;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.todoist.tests.mobile.helpers.DeviceHelper.executeSh;


public class ApkInfoHelper {


    private String apkInfo;


    public ApkInfoHelper() {
        String app = ConfigReader.emulatorConfig.appPath();
        if (app == null || app.isEmpty()) {
            throw new RuntimeException("No value for key 'app' providing apk path in emulator.properties");
        }
        try {

            String pathToApp = "D:\\bul4t\\android\\SDK\\build-tools\\33.0.2\\";
            apkInfo = executeSh(pathToApp + "aapt dumb badging " + ConfigReader.emulatorConfig.appPath());
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAppPackageFromApk() {
        return findGroup1ValueFromString(apkInfo, "package: name='\\s*([^']+?)\\s*'");
    }

    public String getAppMainActivity() {
        return findGroup1ValueFromString(apkInfo, "launchable-activity: name='\\s*([^']+?)\\s*'");
    }

    private static String findGroup1ValueFromString(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
