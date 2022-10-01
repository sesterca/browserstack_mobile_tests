package helpers;

import configuration.BrowserstackConfig;
import configuration.EmulationConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static String videoUrl(String sessionId){
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.browserStackUser(), config.browserStackKey())
                .log().all()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
