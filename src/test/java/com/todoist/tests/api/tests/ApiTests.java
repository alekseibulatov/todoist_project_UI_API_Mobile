package com.todoist.tests.api.tests;

import com.todoist.tests.api.models.ListResponseAllProjectsModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.todoist.tests.api.models.ProjectsModel;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
//import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.DataInput;
import java.util.List;

import static com.todoist.tests.api.specs.LoginSpecs.loginRequestSpec;
import static com.todoist.tests.api.specs.LoginSpecs.responseSpecification;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatList;


public class ApiTests {

    @SneakyThrows
    @Test
    @Tag("api")
    @DisplayName("Получение всех проектов пользователя")
    public void receptionAllProjectTest() {
/*        ListProjectsModel listProjects = given(loginRequestSpec)
                .header("Authorization", "Bearer 9eb84cdd345a55ddf0ba278f893512e30670b4d1")
                .when()
                .get("/projects")
                .then()
                .spec(responseSpecification(200))
               // .contentType(JSON)

                .extract().as(ListProjectsModel.class);*/

        // ObjectMapper objectMapper = new ObjectMapper()
        ListResponseAllProjectsModel listResponseAllProjectsModel = given(loginRequestSpec)
                .header("Authorization", "Bearer 9eb84cdd345a55ddf0ba278f893512e30670b4d1")
                .when()
                .get("/projects")

                .then()
                .spec(responseSpecification(200))
                .extract()
                .as(ListResponseAllProjectsModel.class);


    /*    ObjectMapper objectMapper = new ObjectMapper();

        ListResponseAllProjectsModel person = objectMapper.readValue(authorization, ListResponseAllProjectsModel.class);*/

          /*      .as(new TypeRef<>() {
                });*/
        //  .as(ListResponseAllProjectsModel.class);


       /* System.out.println("ответ");
        System.out.println(person.getList().size());*/

      //    assertThat(listResponseAllProjectsModel.getList().size(), );
         assertThat(listResponseAllProjectsModel.getList().size()).isEqualTo(7);

    /*    ObjectMapper mapper = new ObjectMapper();
        List<ProjectsModel> list = mapper.reader()
                .forType(new TypeReference<List<ProjectsModel>>() {})
                .readValue(String.valueOf(listProjects));

            assertThat(listProjects.toString().length(),is (7));*/

    }
}
