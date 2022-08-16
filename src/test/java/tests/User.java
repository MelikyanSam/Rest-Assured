package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class User {
    @Test
    public void createUser(){


        String userName = "anun";
        String firstName = "Aram";
        String lastName = "Minasyan";
        String email = "aram@mail.ru";
        String password = "aram000";
        String phone = "0********";



        JSONObject requestParams = new JSONObject();
            requestParams.put("id", 0);
            requestParams.put("username", "anun");
            requestParams.put("firstName", "Aram");
            requestParams.put("lastName", "Minasyan");
            requestParams.put("email", "aram@mail.ru");
            requestParams.put("password", "aram000");
            requestParams.put("phone", "0********");
            requestParams.put("userStatus", 0);


        given()
                .auth().basic("api_key", "apiKey")
//                .header("accept", "application/json" )
//                .header("Content-Type", "application/json" )
                .accept("application/json")
                .contentType("application/json")
                .body(requestParams.toString())
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200)
                .body(/*"message", isA(Integer.class),*/
                        "type" , equalTo("unknown"));




        given()
                .auth().basic("api_key", "apiKey")
                .accept("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/anun")
                .then()
                .statusCode(200)
                .assertThat()
                .body(
                        "firstName", equalTo(firstName),
                        "lastName", equalTo(lastName),
                        "email", equalTo(email),
                        "password", equalTo(password),
                        "phone", equalTo(phone)
                ).log().body();
    }


}
