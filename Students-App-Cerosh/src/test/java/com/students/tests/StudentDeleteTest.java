package com.students.tests;

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

public class StudentDeleteTest extends Base{
@Test
public void deleteStudentTest() {
	given()
	.when()
	.delete("/101")
	.then()
	.statusCode(204);
}
}
