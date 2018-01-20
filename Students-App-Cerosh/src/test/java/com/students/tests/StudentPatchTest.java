package com.students.tests;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.Base;
import com.student.model.Student;

public class StudentPatchTest extends Base{
	
	@Test
	public void updateStudent() {
		ArrayList<String> course = new ArrayList();
		course.add("Java");
		course.add("Selenium");
		course.add("PostMan");
		course.add("Rest-Assured");
		Student student = new Student();
		student.setFirstName("CeroshUpdatedUpdated");
		student.setLastName("Jacob");
		student.setEmail("ceroshjacob@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(course);

		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/101")
		.then()
		.statusCode(200);
	}

}
