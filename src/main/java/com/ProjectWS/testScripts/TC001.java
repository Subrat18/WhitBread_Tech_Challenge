package com.ProjectWS.testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ProjectWS.pojoClasses.AddCustomer;
import com.ProjectWS.pojoClasses.DeleteBody;
import com.ProjectWS.pojoClasses.ErrorClass;
import com.ProjectWS.pojoClasses.GetEmail;
import com.ProjectWS.webservices.methods.webservices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;

import junit.framework.Assert;

public class TC001 {

	Response response;

	// @DataProvider(name = "addCustomer")
	public Object[][] addCustomer() {
		Object[][] result = new Object[2][4];

		result[0][0] = "{\r\n\"email\": \"abc@gmail.com\",\r\n\"password\": \"a2q4y4Qu\",\r\n\"firstName\": \"john\",\r\n\"lastName\": \"Allen\",\r\n\"title\": \"Mr\"\r\n}";
		result[0][1] = "abcgmail.com";
		result[0][2] = "john";
		result[0][3] = "Allen";

		result[1][0] = "{\r\n\"email\": \"dyt@gmail.com\",\r\n\"password\": \"a2q4y4Qu\",\r\n\"firstName\": \"\",\r\n\"lastName\": \"Parker\",\r\n\"title\": \"Mr\"\r\n}";
		result[1][1] = "dytgmail.com";
		result[1][2] = "";
		result[1][3] = "Parker";
		return result;
	}

	// @Test(dataProvider = "addCustomer")
	public void verifyResponse(String Json, String email, String firstName, String lastName) {
		System.out.println("inside test");
		Gson gson = new GsonBuilder().create();
		ErrorClass error = new ErrorClass();
		String URI = "https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer";
		response = webservices.Post(URI, Json);
		if (response.getStatusCode() == 200) {
			if (((email == "") || (firstName == "") || (lastName == ""))) {
				error = gson.fromJson(response.asString(), ErrorClass.class);
				System.out.println("Error Message " + error.getErrorMessage());
				String errorMessage = error.getErrorMessage();
				Assert.assertEquals(errorMessage, error.getErrorMessage());
			} else {
				AddCustomer addCustomer = gson.fromJson(response.asString(), AddCustomer.class);
				System.out.println("Body" + addCustomer.getBody());
				String postResponse = addCustomer.getBody().toString();
				String fieldToCheck = "customerId=" + email;
				Assert.assertTrue(postResponse.contains(fieldToCheck));
			}
		}
	}	
}
