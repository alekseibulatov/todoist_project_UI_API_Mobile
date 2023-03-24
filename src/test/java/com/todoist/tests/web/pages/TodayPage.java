package com.todoist.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.todoist.tests.web.tests.WebTestData.*;

public class TodayPage {

    private SelenideElement
            textContentToday = $(".simple_content"),
            buttonAuthMenu = $("[alt=search23search]"),
            userMenuEmail = $(".user_menu_email"),
            buttonLogOut = $$(".user_menu_label").findBy(text(exitLoginButton)),
            captionHeader = $(".caption"),
            captionButtonNoChange = $$(".timezone_link_block").findBy(text(captionDateButton));

    @Step("Проверяем что пользователь авторизировался на сайте")
    public TodayPage verificationSuccessLoginOnTodayPage() {

        textContentToday.shouldHave(Condition.text(headerTextTodayPage));
        buttonAuthMenu.click();
        userMenuEmail.shouldHave(Condition.text("search23search@gmail.com"));

        return this;
    }

    @Step("Разлогиниваемся")
    public TodayPage loginOut() {
        buttonLogOut.click();

        return this;
    }

    @Step("Закрываем всплывающее окно с предложением сенить часовой пояс")
    public TodayPage closeTab() {
        if (captionHeader.exists()) {
            captionButtonNoChange.click();
        } else {
            return null;
        }
        return this;
    }
}
