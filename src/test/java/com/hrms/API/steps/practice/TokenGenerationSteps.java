package com.hrms.API.steps.practice;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//manually written to make given() work
import static io.restassured.RestAssured.*;


public class TokenGenerationSteps {
	
	/**
	 * Storing token as static variable
	 */
	public static String token;
	
	/**
	 * BaseURI
	 */
	String BaseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
	
	@Given("a JWT is generated")
	public void a_JWT_is_generated() {

		/**
		 * making request with given()
		 */
	RequestSpecification generateTokenRequest = given().header("Content-type", "application/json").body("{\r\n" + 
			"  \"email\": \"string123@gmail.com\",\r\n" + 
			"  \"password\": \"string1111\"\r\n" + 
			"}");
	
	
	Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
	
	//generateTokenResponse.prettyPrint();
	
	/**
	 * Retrieving token from generate body and concatenating "Bearer "
	 */
	token="Bearer "+generateTokenResponse.body().jsonPath().getString("token");
	
	/**
	 * Optional to print out token
	 */
	//	System.out.println(token);
	
	}
}
