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

public class TC003 {

	Response response;

	@Test
	public void DeleteCustomer() {
		String URI1 = "https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer/test@gmail.com";
		response = webservices.Delete(URI1);
		if (response.getStatusCode() == 200) {
			System.out.println("Delete Response" + response.toString());
			Gson gson = new GsonBuilder().create();
			DeleteBody deleteBody = new DeleteBody();
			deleteBody = gson.fromJson(response.asString(), DeleteBody.class);
			Assert.assertTrue(deleteBody.getDeleted());

		}

	}

}
