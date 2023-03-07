package com.todoist.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.todoist.tests.web.tests.WebTestData.headerTextTodayPage;

public class TodayPage {

    private SelenideElement
            textContentToday = $(".simple_content"),

    buttonAuthMenu = $("[alt=search23search]"),

    userMenuEmail = $(".user_menu_email");

    @Step("Проверяем что пользователь авторизировался на сайте")
    public TodayPage verificationSuccessLoginOnTodayPage() {

        textContentToday.shouldHave(Condition.text(headerTextTodayPage));
        buttonAuthMenu.click();
        userMenuEmail.shouldHave(Condition.text("search23search@gmail.com"));

        return this;
    }
}
