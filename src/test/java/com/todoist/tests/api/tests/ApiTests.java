package com.todoist.tests.api.tests;

import com.todoist.tests.api.models.ListResponseAllProjectsModel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.todoist.tests.api.specs.LoginSpecs.loginRequestSpec;
import static com.todoist.tests.api.specs.LoginSpecs.responseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ApiTests {

    @SneakyThrows
    @Test
    @Tag("api")
    @DisplayName("Получение всех проектов пользователя")
    public void receptionAllProjectTest() {
        ListResponseAllProjectsModel authorization = given(loginRequestSpec)
                .header("Authorization", "Bearer 9eb84cdd345a55ddf0ba278f893512e30670b4d1")
                .when()
                .get("/projects")
                .then()
                .spec(responseSpecification(200))
                .extract()
                .response()
                .as(ListResponseAllProjectsModel.class);


        String a = authorization.getArrayList().get(0).getId();
        assertThat(a, is("2309139947"));
    }
}
