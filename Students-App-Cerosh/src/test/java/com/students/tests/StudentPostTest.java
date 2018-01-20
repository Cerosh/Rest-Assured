package com.students.tests;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.Base;
import com.student.model.Student;

import static com.jayway.restassured.RestAssured.*;

public class StudentPostTest extends Base{
	
	@Test
	public void createNewStudent() {
		ArrayList<String> course = new ArrayList();
		course.add("Java");
		course.add("Selenium");
		Student student = new Student();
		student.setFirstName("Cerosh");
		student.setLastName("Jacob");
		student.setEmail("cerosh@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(course);

		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	}

}
