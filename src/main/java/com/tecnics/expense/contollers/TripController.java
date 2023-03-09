package com.tecnics.expense.contollers;

import static com.tecnics.expense.utils.Constants.JSON_PROCESSING_FAILED;
import static com.tecnics.expense.utils.Constants.NO_RECORD_FOUND;
import static com.tecnics.expense.utils.Constants.RECORD_IS_ALREADY_EXIST;
import static com.tecnics.expense.utils.ResponseUtility.processResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tecnics.expense.dtos.TripDto;
import com.tecnics.expense.services.TripServices;
import com.tecnics.expense.utils.ResponseMessage;

@RestController
@CrossOrigin("*")

public class TripController {
	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public TripServices tripservices;

	@GetMapping("/fetch/trips")
	public ResponseEntity<ResponseMessage> getAllTrips() {
		List<TripDto> response = null;
		try {
			response = tripservices.getAllTrips();
			if (response == null || response.isEmpty()) {
				errorMessage = NO_RECORD_FOUND;
				response = null;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}


	@PostMapping("/submit/trip")
	public ResponseEntity<ResponseMessage> submitTrip(@RequestBody TripDto trip) {
		TripDto response = null;
		try {
			response = tripservices.submitTrip(trip);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();

		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/trip/{tripId}")
	public ResponseEntity<ResponseMessage> UpdateTrip(@RequestBody TripDto trip,@PathVariable(value = "tripId") Long tripId) {

	TripDto response = null;
	try {
		response = tripservices.updateTrip(trip,tripId);
			
	}catch(DataIntegrityViolationException e) {
		errorMessage = RECORD_IS_ALREADY_EXIST;
		exceptionMsg = e.getMessage();
		
	}catch(Exception e ) {
		errorMessage = JSON_PROCESSING_FAILED;
		exceptionMsg = e.getMessage();
	}
	return processResponse(errorMessage,exceptionMsg,response);
	}

	@DeleteMapping("/delete/trip/{tripId}")
	public ResponseEntity<ResponseMessage>  DeleteTrip(@PathVariable(value ="tripId") Long tripId) {
		try{
			tripservices.deleteTrip(tripId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			tripId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			tripId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg,tripId);
		
		}


		@PostMapping("/trip/approve/{tripId}")
		public ResponseEntity<ResponseMessage> approveTrip(@RequestBody TripDto tripDto,@PathVariable(value = "tripId") long tripId ){

			TripDto response = null;

			try{
					response = tripservices.approveTrip(tripDto, tripId);
			}
			catch(Exception e){
				errorMessage = JSON_PROCESSING_FAILED;
				exceptionMsg = e.getMessage();
			}
			return processResponse(errorMessage, exceptionMsg, response);
		}

		@PostMapping("/trip/reject/{tripId}")
		public ResponseEntity<ResponseMessage> rejectTrip(@RequestBody TripDto tripDto,@PathVariable(value = "tripId") long tripId){

			TripDto response = null;

			try{
				response = tripservices.rejectTrip(tripDto, tripId);
			}
			catch(Exception e){
				errorMessage = JSON_PROCESSING_FAILED;
				exceptionMsg = e.getMessage();
			}
			return processResponse(errorMessage, exceptionMsg, response);
		}

		@PostMapping("save/trip")
		public ResponseEntity<ResponseMessage> saveTrip(@RequestBody TripDto tripDto){

			TripDto response = null;

			try{
				response = tripservices.saveTrip(tripDto);
			}catch (DataIntegrityViolationException e) {
				errorMessage = RECORD_IS_ALREADY_EXIST;
				exceptionMsg = e.getMessage();
			} catch (Exception e) {
				errorMessage = JSON_PROCESSING_FAILED;
				exceptionMsg = e.getMessage();
	
			}

			return processResponse(errorMessage, exceptionMsg, response);
		}



	

//	@GetMapping("/fetch/trip/{tripId}")
//	public ResponseEntity<ResponseMessage> getTripById(@PathVariable(value = "tripId") Long tripId) {
//		TripDto response = null;
//		try {
//			response = tripservices.getTripById(tripId);
//			if (response == null) {
//				errorMessage = NO_RECORD_FOUND;
//			}
//		} catch (Exception e) {
//			errorMessage = JSON_PROCESSING_FAILED;
//			exceptionMsg = e.getMessage();
//
//		}
//		return processResponse(errorMessage, exceptionMsg, response);
//
//	}
//	
//	@GetMapping("/fetch/tripByName/{tripName}")
//	public ResponseEntity<ResponseMessage> getTripByName(@PathVariable(value ="tripName") String tripName){
//		
//		TripDto response = null;
//		try {
//			response = tripservices.getTripByName(tripName);
//			if(response == null) {
//				errorMessage = NO_RECORD_FOUND;
//			}
//		} catch (Exception e) {
//			errorMessage = JSON_PROCESSING_FAILED;
//			exceptionMsg = e.getMessage();
//
//		}
//		return processResponse(errorMessage,exceptionMsg,response);
//	}
}
