package com.ProjectWS.webservices.methods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class webservices {
	
	public static Response Post(String URI,String stringJSON)
	{
		
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		
		requestSpecification.contentType(ContentType.JSON);		
		Response response = requestSpecification.post(URI);
		
		return response;
		
	}
	

	public static Response Get(String URI)
	{
		
		RequestSpecification requestSpecification = RestAssured.given();		
		requestSpecification.contentType(ContentType.JSON);		
		Response response = requestSpecification.get(URI);		
		return response;
		
	}
	

	public static Response Put(String URI,String stringJSON)
	{
		
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);		
		requestSpecification.contentType(ContentType.JSON);		
		Response response = requestSpecification.put(URI);
		
		return response;
		
	}
	
	public static Response Delete(String URI)
	{
		
		RequestSpecification requestSpecification = RestAssured.given();		
		requestSpecification.contentType(ContentType.JSON);		
		Response response = requestSpecification.delete(URI);
		
		return response;
		
	}
	
}
	
	