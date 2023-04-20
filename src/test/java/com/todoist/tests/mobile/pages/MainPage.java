package com.todoist.tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {
    private final SelenideElement

            adPopUp = $(id("com.todoist:id/parentPanel")),
            buttonPopUpNot = $(id("android:id/button2")),
            toolbarToday = $(id("com.todoist:id/toolbar"));

    @Step("Проверяем успешную загрузку главной страницы")
    public MainPage successLogin() {
        toolbarToday.exists();

        return this;
    }

    @Step("Закрываем открывшееся всплывающее окно")
    public MainPage closePopUp() {
        if (adPopUp.exists()) {

            buttonPopUpNot.click();
        }

        return this;
    }
}
