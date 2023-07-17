package org.Testing.tests.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;
import org.Testing.actions.AssertActions;
import org.Testing.endpoints.APIConstants;
import org.Testing.module.PayLoadManager;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Collection;
import java.util.Map;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayLoadManager payLoadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeMethod
    public void setupconfig(){

        payLoadManager = new PayLoadManager();
        assertActions = new AssertActions();

        requestSpecification = (RequestSpecification) new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json").build().log().all();

    }

    public String getToken(){

        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL).basePath("/auth");

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        response = requestSpecification.contentType(ContentType.JSON)
                .body(payload)
                .when().post();

        jsonPath = new JsonPath(response.asString());
        return  jsonPath.getString("token");

    }
    @BeforeMethod
    public void teardown(){
        System.out.println("END !! ");
    }

}
