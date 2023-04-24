package com.todoist.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    private final SelenideElement

            adPopUp = $(id("com.todoist:id/parentPanel")),
            buttonPopUpNot = $(id("android:id/button2")),
            toolbarToday = $(id("com.todoist:id/toolbar")),
            buttonMenu = $(accessibilityId("Menu")),
            buttonTestProject = $(byAttribute("text", "TestProject")),
            buttonFastAddTask = $(id("com.todoist:id/fab")),
            toolBarFastAddTaskWindow = $(id("android:id/message")),
            buttonAddText = $(id("android:id/button1")),
            newTask = $(byAttribute("text", "Тест_задача"));

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

    @Step("Нажимаем на кнопку Menu на главной странице")
    public MainPage clickToButtonMenu() {
        buttonMenu.click();

        return this;
    }

    @Step("Выбираем проект TestProject в списке")
    public MainPage choiceProjectTestProject() {
        buttonTestProject.click();

        return this;
    }

    @Step("Нажимаем на кнопку добавить задачу на главной странице")
    public MainPage clickToButtonFastAddTask() {
        buttonFastAddTask.click();

        return this;
    }

    @Step("Проверяем, что окно быстрого ввода задачи открылось")
    public MainPage checkOpenWindowFastAddTask() {
        toolBarFastAddTaskWindow.shouldHave(Condition.text("Task name"));

        return this;
    }

    @Step("Добавляем задачу 'Тест_задача' в проект TestProject")
    public MainPage addNewTaskToWindowFastAddTask() {
        toolBarFastAddTaskWindow.sendKeys("Тест_задача");
        buttonAddText.click();

        return this;
    }

    public MainPage checkAddNewTaskToProject() {
        assertThat(newTask.exists());

        return this;
    }
}
