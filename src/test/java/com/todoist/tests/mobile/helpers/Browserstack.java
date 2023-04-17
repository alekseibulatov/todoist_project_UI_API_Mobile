package com.todoist.tests.mobile.helpers;

import com.todoist.tests.mobile.config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.todoist.tests.mobile.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;


public class Browserstack {
    public static String getVideoUrl(String sessionId) {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(authConfig.login(), authConfig.password())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
