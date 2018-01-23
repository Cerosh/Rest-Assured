package com.student.base;

import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;

public class Base {
	@BeforeClass
public static void init() {
	RestAssured.baseURI="http://localhost";
	RestAssured.port=8080;
	RestAssured.basePath="/student";
}
}
