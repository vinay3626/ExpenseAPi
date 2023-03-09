package com.tecnics.expense.utils;

public class ResponseError {
	
	 private String errorMessage;
	  private String errorTrace;

	  public ResponseError(String errorMessage, String trace) {
	    super();
	    this.errorMessage = errorMessage;
	    this.errorTrace = trace;
	  }

	  public String getErrorMessage() {
	    return errorMessage;
	  }

	  public void setErrorMessage(String errorMessage) {
	    this.errorMessage = errorMessage;
	  }

	  public String getErrorTrace() {
	    return errorTrace;
	  }

	  public void setErrorTrace(String errorTrace) {
	    this.errorTrace = errorTrace;
	  }
}
