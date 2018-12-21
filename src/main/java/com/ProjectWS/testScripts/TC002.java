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

public class TC002 {

	Response response;

	@Test
	public void getCustomer() {
		String URI1 = "https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer/test@gmail.com";
		response = webservices.Get(URI1);

		if (response.getStatusCode() == 200) {
			Gson gson = new GsonBuilder().create();
			GetEmail getEmail = gson.fromJson(response.asString(), GetEmail.class);
			System.out.println("email id" + getEmail.getCustomerId());
			String postResponse = getEmail.getCustomerId();
			String EmailToCheck = "test@gmail.com";
			Assert.assertEquals(EmailToCheck, getEmail.getCustomerId());
		}

	}
}
