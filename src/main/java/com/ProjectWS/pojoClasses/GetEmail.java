package com.ProjectWS.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetEmail {

@SerializedName("customerId")
@Expose
private String customerId;

public String getCustomerId() {
return customerId;
}

public void setCustomerId(String customerId) {
this.customerId = customerId;
}

}
