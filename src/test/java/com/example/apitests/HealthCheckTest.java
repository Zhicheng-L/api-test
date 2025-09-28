package com.example.apitests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HealthCheckTest extends BaseTest {

    @Test
    @Description("健康检查接口，验证系统是否正常运行")
    void testHealthCheck() {
        given()
                .when()
                .get("/health")
                .then()
                .statusCode(200)
                .body("status", equalTo("UP"));
    }
}
