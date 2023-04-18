package com.todoist.tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.todoist.tests.api.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;


public class LoginSpecs {
    public static RequestSpecification loginRequestSpec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .header("Authorization", "Bearer 9eb84cdd345a55ddf0ba278f893512e30670b4d1")
            .baseUri("https://api.todoist.com")
            .basePath("/rest/v2");


    public static ResponseSpecification responseSpecification(int status) {
        return new ResponseSpecBuilder()
                .log(ALL)
                .expectStatusCode(status)
                .build();

    }
}
