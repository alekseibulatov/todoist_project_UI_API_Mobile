package com.todoist.tests.api.tests;

import com.todoist.tests.api.models.CreateNewProjectModel;
import com.todoist.tests.api.models.CreateNewTaskToProject;
import com.todoist.tests.api.models.ListResponseAllProjectsModel;
import com.todoist.tests.api.models.ProjectsModel;
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


    @Test
    @Tag("api")
    @DisplayName("Добавление нового проекта")
    public void addNewProjectTest() {
        CreateNewProjectModel newProjectModel = new CreateNewProjectModel();
        newProjectModel.setName("QA.GURU");

        ProjectsModel newProject = given(loginRequestSpec)
                .header("Authorization", "Bearer 9eb84cdd345a55ddf0ba278f893512e30670b4d1")
                .body(newProjectModel)
                .when()
                .post("/projects")
                .then()
                .spec(responseSpecification(200))
                .extract()
                .as(ProjectsModel.class);

        assertThat(newProject.getName(), is("QA.GURU"));

        assertThat(newProject.getOrder(), is(7));
    }

    @Test
    @Tag("api")
    @DisplayName("Удаление   проекта Shopping из списка проектов")
    public void deleteProjectTest() {
        given(loginRequestSpec)
                .header("Authorization", "Bearer 9eb84cdd345a55ddf0ba278f893512e30670b4d1")
                .when()
                .delete("/projects/2309199795")
                .then()
                .spec(responseSpecification(204));
    }

    @Test
    @Tag("api")
    @DisplayName("Добавление новой задачи в проект 'TestProject'")
    public void addTaskToProject() {
        CreateNewTaskToProject createNewTaskToProject = new CreateNewTaskToProject();
        createNewTaskToProject.setContent("Тестовая задача");
        createNewTaskToProject.setProjectId("2309196479");

        given(loginRequestSpec)
                .header("Authorization", "Bearer 9eb84cdd345a55ddf0ba278f893512e30670b4d1")
                .body(createNewTaskToProject)
                .when()
                .post("/tasks")
                .then()
                .spec(responseSpecification(200))
                .body("content", is("Тестовая задача"));

    }
}
