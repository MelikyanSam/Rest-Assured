//import static io.restassured.path.json.JsonPath.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MyFirstRestAssuredClass {
    @Test
    public static void getResponseBody() {
        given().
                when().
                get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").
                then().
                log().all();
    }


}
