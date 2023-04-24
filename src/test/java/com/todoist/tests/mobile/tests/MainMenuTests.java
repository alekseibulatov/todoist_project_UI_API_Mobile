package com.todoist.tests.mobile.tests;

import com.codeborne.selenide.Selectors;
import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainMenuTests extends TestBase {


    @Test
    @Description("Добавление новой задачи в проект TestProject")
    @Tag("Mobile")
    public void addNewTaskToTestProject() {
        authPage.clickToButtonMoreOptions()
                .clickToButtonLoginWithEmail()
                .setValueEmailGoogle()
                .setValuePasswordGoogle()
                .clickToSLoginButton();

        mainPage.closePopUp()
                .successLogin()
                .clickToButtonMenu()
                .choiceProjectTestProject()
                .clickToButtonFastAddTask()
                .checkOpenWindowFastAddTask()
                .addNewTaskToWindowFastAddTask();
        back();

        mainPage.checkAddNewTaskToProject();
    }
}
