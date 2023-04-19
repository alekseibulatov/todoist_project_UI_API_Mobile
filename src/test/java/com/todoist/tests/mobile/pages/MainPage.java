package com.todoist.tests.mobile.pages;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {

    public void clickToButton() {
        $(id("com.todoist:id/btn_google")).click();
    }
}
