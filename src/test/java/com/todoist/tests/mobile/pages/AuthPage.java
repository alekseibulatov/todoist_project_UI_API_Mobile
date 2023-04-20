package com.todoist.tests.mobile.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class AuthPage {

    public AuthPage clickToButtonMoreOptions() {
        $(id("com.todoist:id/more_signin_options")).click();
        return this;
    }

    public AuthPage clickToButtonLoginWithEmail() {
        $(id("com.todoist:id/email_login")).click();
        return this;
    }

    public AuthPage setValueEmailGoogle() {
        $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.widget.ScrollView/android.widget.EditText[1]")).sendKeys("search23search@gmail.com");

        return this;
    }


    public AuthPage setValuePasswordGoogle() {
        $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.widget.ScrollView/android.widget.EditText[2]")).sendKeys("123!45678");

        return this;

    }

    public AuthPage clickToSLoginButton() {
        $(xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                "android.widget.ScrollView/android.view.View[1]")).click();

        return this;
    }
}
