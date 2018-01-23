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

public class LoggingRequestValues extends Base {
	@Test
	public void test001() {
		System.out.println("-------Printing Request Header-----------");
		given().log().headers().when().get("/1").then().statusCode(200);
	}

	@Test
	public void test002() {
		ArrayList<String> course = new ArrayList();
		course.add("Java");
		course.add("Selenium");
		Student student = new Student();
		student.setFirstName("Cerosh");
		student.setLastName("Jacob");
		student.setEmail("cerosh4@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(course);
		System.out.println("-----------Priniting Request Body------");
		given()
		.contentType(ContentType.JSON)
		.log()
		.body()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	}
	@Test
	public void test003() {
		System.out.println("---------Printing out Cookies------------");
		given()
		.log()
		.cookies()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
	}
	@Test
	public void test004() {
		System.out.println("----------Printing out Request Parameters-----");
		given()
		.param("Programme", "Computer Science")
		.param("limit", 1)
		.log()
		.params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
	@Test
	public void test005() {
		ArrayList<String> course = new ArrayList();
		course.add("Java");
		course.add("Selenium");
		Student student = new Student();
		student.setFirstName("Cerosh");
		student.setLastName("Jacob");
		student.setEmail("cerosh2@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(course);
		System.out.println("_____________Prininting out All the details_____________");
		given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	}
	@Test
	public void test006() {
		ArrayList<String> course = new ArrayList();
		course.add("Java");
		course.add("Selenium");
		Student student = new Student();
		student.setFirstName("Cerosh");
		student.setLastName("Jacob");
		student.setEmail("cerosh9@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(course);
		System.out.println("_____________Prininting out details if validation fails____________");
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	}
}
