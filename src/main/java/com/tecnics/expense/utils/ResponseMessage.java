package com.tecnics.expense.utils;

//import java.util.Date;


public class ResponseMessage {

	private ResponseError errors;

	private boolean hasError = false;

	private Object results;

//	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
//	private Date timestamp = new Date();

	public ResponseMessage(ResponseError errors) {
		super();
		this.setHasError(true);
		this.setErrors(errors);
		this.setResults(results);
	}

	public ResponseMessage(Object results) {
		super();
		this.setResults(results);
	}


	public ResponseError getErrors() {
		return errors;
	}

	public Object getResults() {
		return results;
	}

//	public Date getTimestamp() {
//		return new Date(timestamp.getTime());
//	}

	public boolean isHasError() {
		return hasError;
	}

	public void setErrors(ResponseError errors) {
		this.errors = errors;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public void setResults(Object results) {
		this.results = results;
	}

//	public void setTimestamp(Date timestamp) {
//		this.timestamp = new Date(timestamp.getTime());
//
//	}
}
