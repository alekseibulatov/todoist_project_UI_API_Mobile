package com.todoist.tests.mobile.tests;

import com.todoist.tests.mobile.pages.MainPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MainMenuTests extends TestBase {

    private static MainPage mainPage;

    @BeforeAll
    public static void init() {
        mainPage = new MainPage();
    }

    @Test
    @Description("Открываем главную страницу")
    @Tag("Mobile")
    public void testMainPage() {
        mainPage.clickToButton();
    }
}
