package com.todoist.tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class AuthPage {
    private final SelenideElement

            buttonWithMoreOptions = $(id("com.todoist:id/more_signin_options")),
            buttonLoginWithEmail = $(id("com.todoist:id/email_login")),
            fieldEmail = $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                    "android.widget.ScrollView/android.widget.EditText[1]")),
            fieldPassword = $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                    "android.widget.ScrollView/android.widget.EditText[2]")),
            buttonLogin = $(xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
                    "android.widget.ScrollView/android.view.View[1]"));

    @Step("Нажимаем на кнопку Continue with more options")
    public AuthPage clickToButtonMoreOptions() {
        buttonWithMoreOptions.click();
        return this;
    }

    @Step("Выбираем из списка Login with Email")
    public AuthPage clickToButtonLoginWithEmail() {
        buttonLoginWithEmail.click();
        return this;
    }

    @Step("Вводим  email")
    public AuthPage setValueEmailGoogle() {
        fieldEmail.sendKeys("search23search@gmail.com");

        return this;
    }

    @Step("Вводим пароль")
    public AuthPage setValuePasswordGoogle() {
        fieldPassword.sendKeys("123!45678");

        return this;

    }

    @Step("Нажимаем на кнопку Log in ")
    public AuthPage clickToSLoginButton() {
        buttonLogin.click();

        return this;
    }
}
