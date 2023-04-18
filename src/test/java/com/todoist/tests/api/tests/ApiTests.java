package com.todoist.tests.api.tests;

import com.todoist.tests.api.models.*;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.todoist.tests.api.specs.LoginSpecs.loginRequestSpec;
import static com.todoist.tests.api.specs.LoginSpecs.responseSpecification;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ApiTests {

    @SneakyThrows
    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Api")
    @DisplayName("Получение всех проектов пользователя")
    public void receptionAllProjectTest() {
        ListResponseAllProjectsModel authorization = step("Получаем все проекты пользователя", () ->
                given(loginRequestSpec)
                        .when()
                        .get("/projects")
                        .then()
                        .spec(responseSpecification(200))
                        .extract()
                        .response()
                        .as(ListResponseAllProjectsModel.class));

        step("Проверяем, что число проектов - три", () -> {
                    assertThat(authorization.getArrayList().size(), is(2));
        });
    }


    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Api")
    @DisplayName("Добавление нового проекта QA.GURU в проекты")
    public void addNewProjectTest() {
        CreateNewProjectModel newProjectModel = new CreateNewProjectModel();
        newProjectModel.setName("QA.GURU");

        ProjectsModel newProject = step("Создаем   проект QA.GURU", () ->
                given(loginRequestSpec)
                        .body(newProjectModel)
                        .when()
                        .post("/projects")
                        .then()
                        .spec(responseSpecification(200))
                        .extract()
                        .as(ProjectsModel.class));

        step("Проверяем, что  проект QA.GURU", () -> {
            assertThat(newProject.getName(), is("QA.GURU"));
        });

        step("Возвращаем систему в исходное состояние,удаляем   проект QA.GURU", () ->
                given(loginRequestSpec)
                        .when()
                        .delete("/projects/" + newProject.getId())
                        .then()
                        .spec(responseSpecification(204)));
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.MINOR)
    @Tag("Api")
    @DisplayName("Удаление   проекта Shopping из списка проектов")
    public void deleteProjectTest() {
        CreateNewProjectModel newProjectModel = new CreateNewProjectModel();
        newProjectModel.setName("Shopping");

        ProjectsModel newProject = step("Создаем   проект Shopping", () ->
                given(loginRequestSpec)
                        .body(newProjectModel)
                        .when()
                        .post("/projects")
                        .then()
                        .spec(responseSpecification(200))
                        .extract()
                        .as(ProjectsModel.class));

        step("Проверяем, что  проект Shopping создан", () -> {
            assertThat(newProject.getName(), is("Shopping"));
        });

        step("Удаляем   проект Shopping из списка проектов, получаем статус ответа 204", () ->
                given(loginRequestSpec)
                        .when()
                        .delete("/projects/" + newProject.getId())
                        .then()
                        .spec(responseSpecification(204)));
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Api")
    @DisplayName("Добавление новой задачи в проект 'TestProject'")
    public void addTaskToProject() {
        CreateNewTaskToProject createNewTaskToProject = new CreateNewTaskToProject();
        createNewTaskToProject.setContent("Тестовая задача");
        createNewTaskToProject.setProjectId("2309196479");

        TaskModel createTaskToProject = step("Создаем задачу 'Тестовая задача для удаления' в проекте 'TestProject'", () ->
                given(loginRequestSpec)
                        .body(createNewTaskToProject)
                        .when()
                        .post("/tasks")
                        .then()
                        .spec(responseSpecification(200))
                        .body("content", is("Тестовая задача"))
                        .extract().as(TaskModel.class));

        step("Проверяем, что  'Тестовая задача для удаления' создана в  проекте 'TestProject'", () -> {
            assertThat(createTaskToProject.getContent(), is("Тестовая задача"));
        });
    }

    @Test
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.MINOR)
    @Tag("Api")
    @DisplayName("Удаление новой задачи в проект 'TestProject'")
    public void closingTaskInProject() {


        CreateNewTaskToProject createNewTaskToProject = new CreateNewTaskToProject();
        createNewTaskToProject.setContent("Тестовая задача для удаления");
        createNewTaskToProject.setProjectId("2309196479");


        TaskModel createNewTask = step("Создаем задачу 'Тестовая задача для удаления' в проекте 'TestProject'", () ->
                given(loginRequestSpec)
                        .body(createNewTaskToProject)
                        .when()
                        .post("/tasks")
                        .then()
                        .spec(responseSpecification(200))
                        .body("content", is("Тестовая задача для удаления"))
                        .extract().as(TaskModel.class));

        step("Проверяем, что  'Тестовая задача для удаления' создана в  проекте 'TestProject'", () -> {
            assertThat(createNewTask.getContent(), is("Тестовая задача для удаления"));
        });

        step("Удаляем задачу 'Тестовая задача для удаления' из проекта 'TestProject'", () -> {
            given(loginRequestSpec)
                    .when()
                    .post("/tasks/" + createNewTask.getId() + "/close")
                    .then()
                    .spec(responseSpecification(204));
        });
    }
}
