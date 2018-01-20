package com.students.tests;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.student.base.Base;

import static com.jayway.restassured.RestAssured.*;

public class StudentGetTest extends Base{
	
	@Test
	public void getAllStudentInformation() {
	Response response =	given()
		.when()
		.get("/list");
	System.out.println(response.body().asString());
	System.out.println(response.body().prettyPrint());
	}
	
	@Test
	public void validateStatusCode() {
		given()
		.when()
		.get("/list")
		.then()
		.statusCode(400);
	}
	@Test
	public void getStudentInfo() {
		Response response = given()
		.when()
		.get("/1");
		System.out.println(response.body().prettyPrint());
		
	}
	@Test
	public void getStudentFromFA() {
		Response response =given()
		.when()
		.get("/list?programme= Financial Analysis&limit = 2");
		System.out.println(response.prettyPrint());
		
		Response response2 = given()
				.param("programme", "Financial Analysis")
				.param("limit", 2)
				.when()
				.get("/list");
		System.out.println(response2.prettyPeek());
	}
	
}
