package com.ProjectWS.pojoClasses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorClass {

@SerializedName("errorMessage")
@Expose
private String errorMessage;
@SerializedName("errorType")
@Expose
private String errorType;
@SerializedName("stackTrace")
@Expose
private List<String> stackTrace = null;

public String getErrorMessage() {
return errorMessage;
}

public void setErrorMessage(String errorMessage) {
this.errorMessage = errorMessage;
}

public String getErrorType() {
return errorType;
}

public void setErrorType(String errorType) {
this.errorType = errorType;
}

public List<String> getStackTrace() {
return stackTrace;
}

public void setStackTrace(List<String> stackTrace) {
this.stackTrace = stackTrace;
}

}