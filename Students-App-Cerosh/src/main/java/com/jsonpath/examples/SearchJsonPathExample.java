package com.jsonpath.examples;

import org.junit.BeforeClass;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.base.Base;
import com.jayway.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import com.jayway.restassured.RestAssured;

public class SearchJsonPathExample {
	static final String APIKEY = "pcbvwyb64hnyhm2hbky7wfyr";

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
	}

	@Test
	public void extractNumItems() {
		int numItems = given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then().extract().path("numItems");
System.out.println("Extracted numItems: "+numItems);
	}

	@Test
    public void extractQuery() {
          String queryValue = given()
                       .queryParam("query", "ipod")
                       .queryParam("apiKey", APIKEY)
                       .queryParam("format", "json")
                       .when()
                       .get("/search")
                       .then().extract().path("query");
          System.out.println("The search query is: " + queryValue);
    }

    @Test
    public void extractProductName() {
          String productName = given()
                       .queryParam("query", "ipod")
                       .queryParam("apiKey", APIKEY)
                       .queryParam("format", "json")
                       .when().get("/search")
                       .then()
                       .extract().path("items[0].name");
          System.out.println("Extracted Product name by providing list index value:  " + productName);
    } 

    @Test
    public void extractGiftOptions() {
          HashMap<String, String> giftOptions = given()
                       .queryParam("query", "ipod")
                       .queryParam("apiKey", APIKEY)
                       .queryParam("format", "json")
                       .when()
                       .get("/search")
                       .then()
                        .extract().path("items[0].giftOptions");
          System.out.println("Gift options extracted are: " + giftOptions);
    }  

    @Test
    public void printSize() {
          int size = given()
                       .queryParam("query", "ipod")
                       .queryParam("apiKey", APIKEY)
                       .queryParam("format", "json")
                       .when()
                       .get("/search")
                       .then()
                       .extract().path("items.size");
          System.out.println("The size of the item is: " + size);
    }  

    @Test

    public void getAllNames() {
          List<String> names = given()
                       .queryParam("query", "ipod")
                       .queryParam("apiKey", APIKEY)
                       .queryParam("format", "json")
                       .when()
                       .get("/search")
                       .then()
                       .extract().path("items.name");
          System.out.println("The names of the product are: " + names);
    }
  
    @Test
    public void valuesWithItemName() {
          List<HashMap<String, Object>> values = given()
                       .queryParam("query", "ipod")
                       .queryParam("apiKey", APIKEY)
                       .queryParam("format", "json")
                       .when()
                       .get("/search")
                       .then()
                        .extract().path("items.findAll{it.name=='Apple iPod touch 32GB'}");
          System.out.println("The values for items name Apple iPod touch 32GB are :" + values);
    }

    @Test
    public void oneValueWithItemName() {
          List<HashMap<String, Object>> salePrice = given()
                       .queryParam("query", "ipod")
                       .queryParam("apiKey", APIKEY)
                       .queryParam("format", "json")
                       .when()
                       .get("/search")
                       .then()
                        .extract().path("items.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");
          System.out.println("The Sale Price is: " + salePrice);
    }
   
    @Test
    public void getItemsWithPriceLmt() {
          List<String> names = given()
        		  			.queryParam("query", "ipod")
        		  			.queryParam("apiKey", APIKEY)
        		  			.queryParam("format", "json")
        		  			.when()
        		  			.get("/search")
        		  			.then()
        		  			.extract().path("items.findAll{it.salePrice<150}.name");
          System.out.println("The items that are priced less than $150 are: " + names);
    }

    @Test
    public void wildCharactersStartWith() {
          List<String> msrpValues = given()
        		  			.queryParam("query", "ipod")
        		  			.queryParam("apiKey", APIKEY)
        		  			.queryParam("format", "json").when().get("/search").then().extract()
                        .path("items.findAll{it.name==~/Ref.*/}.msrp");
          System.out.println("The msrp of items that start with Ref are:" + msrpValues);
    } 

    @Test
    public void wildCharacterEndsWith() {
          List<String> salePrice = given()
        		  			.queryParam("query", "ipod")
        		  			.queryParam("apiKey", APIKEY)
                       	.queryParam("format", "json")
                       	.when().get("/search")
                       	.then()
                       	.extract().path("items.findAll{it.name==~/.*ed/}.salePrice");
          System.out.println("The msrp of items that end with ed are: " + salePrice);
    }
}
