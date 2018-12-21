package com.ProjectWS.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jayway.restassured.response.Headers;

public class AddCustomer<Body> {

@SerializedName("statusCode")
@Expose
private Integer statusCode;
@SerializedName("headers")
@Expose
private Headers headers;
@SerializedName("body")
@Expose
private Body body;

public Integer getStatusCode() {
return statusCode;
}

public void setStatusCode(Integer statusCode) {
this.statusCode = statusCode;
}

public Headers getHeaders() {
return headers;
}

public void setHeaders(Headers headers) {
this.headers = headers;
}

public Body getBody() {
return body;
}

public void setBody(Body body) {
this.body = body;
}

}