package org.Testing.tests.integrationtests;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.Testing.endpoints.APIConstants;
import org.Testing.tests.base.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import javax.sql.rowset.spi.SyncResolver;

public class IntegrationTest1 extends BaseTest {
    String token;
    @Test(groups = "integration")
    @Owner("Ishu Anand")
    @Description("Verify Create Booking")
    public void testCreateBooking(ITestContext iTestContext) throws JsonProcessingException {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        requestSpecification.contentType(ContentType.JSON);
        response = RestAssured.given().spec(requestSpecification).when().body(payLoadManager.createPayload()).post();
        validatableResponse =response.then().log().all();
        jsonPath = JsonPath.from(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        System.out.println("Booking ID" + bookingId);
        validatableResponse.statusCode(200);
        // AssertJ bookingid

        iTestContext.setAttribute("bookingid", jsonPath.getString("bookingid"));

    }
    @Test(groups = "integration", dependsOnMethods = "testCreateBooking")
    @Owner("Ishu Anand")
    @Description("Verify Full Update of previous Booking works fine")
    public void testCreateAndUpdatebooking(ITestContext iTestContext) throws JsonProcessingException {

       token  = getToken();
       String bookingId = (String) iTestContext.getAttribute("bookingid");
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingId);
        response = RestAssured.given().spec(requestSpecification).cookie("token",token).when().body(payLoadManager.updatepayload()).put();
        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);



    }
    @Test(groups = "integration", dependsOnMethods = "testCreateAndUpdatebooking")
    @Owner("Ishu Anand")
    @Description("Verify Deletion of Previous Booking")
    public void testDeleteCreatedbooking(ITestContext iTestContext){

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + (String) iTestContext.getAttribute("bookingid")).cookie("token",token);
        validatableResponse = RestAssured.given().spec(requestSpecification).auth().preemptive().basic("admin","password123")
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);



    }

}
