package com.example.apitests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends BaseTest {

    @Test
    @Description("用户登录接口，验证返回token")
    void testLogin() {
        given()
                .contentType("application/json")
                .body("{\"username\": \"test\", \"password\": \"123456\"}")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }
}
