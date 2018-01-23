package com.students.logging.examples;

import com.student.base.Base;
import com.student.model.Student;

import org.junit.BeforeClass;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.base.Base;
import com.jayway.restassured.RestAssured;

public class LoggingResponseValues extends Base {
	@Test
	public void test001() {
		System.out.println("----------Printing out Response Headers-----");
		given()
		.param("Programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200);
	}
	@Test
	public void test002() {
		System.out.println("----------Printing out Response Status Line-----");
		given()
		.param("Programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.status()
		.statusCode(200);
	}
	@Test
	public void test003() {
		System.out.println("----------Printing out Response Body-----");
		given()
		.param("Programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	@Test
	public void test004() {
		System.out.println("----------Printing out Response Body in case of an error-----");
		given()
		.param("Programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.ifError()
		.statusCode(200);
	}

}
