package com.tecnics.expense.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtility {

	private ResponseUtility() {
		throw new IllegalStateException("Instantiating utility class.");
	}

	public static ResponseEntity<ResponseMessage> processResponse(
			String errorMessage,
			String exceptionMsg,
			Object responseList
			) {
		if (responseList == null) {
			return ResponseEntity	
					.status(HttpStatus.EXPECTATION_FAILED)
					.body(
							new ResponseMessage(new ResponseError(errorMessage, exceptionMsg))
							);
		}
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new ResponseMessage(responseList));
	}	
}
