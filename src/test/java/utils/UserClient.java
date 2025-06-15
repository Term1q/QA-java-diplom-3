package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";

    public Response createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(user)
                .post("auth/register");
    }

    public Response loginUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(user)
                .post("auth/login");
    }

    public void deleteUser(User user) {
        Response loginResponse = loginUser(user);
        String token = loginResponse.path("accessToken");

        given()
                .header("Authorization", token)
                .baseUri(BASE_URL)
                .delete("auth/user");
    }
}