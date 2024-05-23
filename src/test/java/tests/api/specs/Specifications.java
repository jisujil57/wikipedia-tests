package tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.lessThan;
import static tests.web.BaseWebTest.BASE_URL;

public class Specifications {
        private static final long MAX_RESPONSE_TIME = 2000L;
        private static final String BASE_PATH = "/wiki";

        public static RequestSpecification requestSpec = with()
                .filter(withCustomTemplates())
                .log().uri()
                .log().method()
                .log().body()
                .log().headers()
                .contentType(JSON)
                .header("Accept-Encoding", "gzip, deflate, br, zstd")
                .baseUri(BASE_URL)
                .basePath(BASE_PATH);

        public static ResponseSpecification responseSpecOk200 = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(MAX_RESPONSE_TIME))
                .log(STATUS)
                .log(BODY)
                .build();

        public static ResponseSpecification responseWithoutStatusCode= new ResponseSpecBuilder()
                .expectResponseTime(lessThan(MAX_RESPONSE_TIME))
                .log(STATUS)
                .log(BODY)
                .build();

        public static ResponseSpecification responseSpecNoContent204 = new ResponseSpecBuilder()
                .expectStatusCode(204)
                .expectResponseTime(lessThan(MAX_RESPONSE_TIME))
                .log(STATUS)
                .log(BODY)
                .build();
}
