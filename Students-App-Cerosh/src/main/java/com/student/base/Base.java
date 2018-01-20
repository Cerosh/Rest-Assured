package com.student.base;

import com.jayway.restassured.RestAssured;

public class Base {
public static void init() {
	RestAssured.baseURI="";
	RestAssured.port=8080;
	RestAssured.basePath="";
}
}
