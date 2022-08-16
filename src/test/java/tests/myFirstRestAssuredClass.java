package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class myFirstRestAssuredClass {
    @Test
    public void getResponseBody(){
        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234")
                .queryParam("Account_No","1")
                .when()
                .get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
                .then()
                .log().body();
    }

    public void getResponseStatus(){
        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234")
                .queryParam("Account_No","1")
                .when()
                .get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
                .then()
                .log().body();
    }
}
