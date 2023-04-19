package com.todoist.tests.mobile.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

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
        $(id("email")).click();
        $(id("email")).setValue("search23search@gmail.com");

        return this;
    }


    public AuthPage setValuePasswordGoogle() {
        $(id("password")).click();
        $(id("password")).setValue("123!45678");
        return this;

    }

    public AuthPage clickToSLoginButton() {
        $(id("auth_button_tag")).click();

        return this;
    }
}
