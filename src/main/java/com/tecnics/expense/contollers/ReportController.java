package com.tecnics.expense.contollers;

import java.util.List;

import static com.tecnics.expense.utils.Constants.JSON_PROCESSING_FAILED;
import static com.tecnics.expense.utils.Constants.NO_RECORD_FOUND;
import static com.tecnics.expense.utils.Constants.RECORD_IS_ALREADY_EXIST;
import static com.tecnics.expense.utils.ResponseUtility.processResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tecnics.expense.dtos.ReportDto;
import com.tecnics.expense.services.ReportServices;
import com.tecnics.expense.utils.ResponseMessage;

@RestController
@CrossOrigin("*")

public class ReportController {


	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	private ReportServices reportservices;

	@GetMapping("/fetch/reports")
	public ResponseEntity<ResponseMessage> getReportDetails() {
		List<ReportDto> response = null;
		try {
			response = reportservices.getReportDetails();
			if (response == null|| response.isEmpty()) {
				errorMessage = NO_RECORD_FOUND;
				response = null;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}


	@PostMapping("/save/report")
	public ResponseEntity<ResponseMessage> createReport(@RequestBody ReportDto report) {
		ReportDto response = null;
		try {
			response = reportservices.createReport(report);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();

		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/report/{reportId}")
	public ResponseEntity<ResponseMessage> UpdateReport(@RequestBody ReportDto report,@PathVariable(value = "reportId") Long reportId) {
		ReportDto response = null;
		try {
			response = reportservices.updateReport(report,reportId);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();

		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@DeleteMapping("delete/report/{reportId}")
	public ResponseEntity<ResponseMessage> DeleteReport(@PathVariable(value = "reportId") Long reportId) {
		try{reportservices.deleteReport(reportId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			reportId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			reportId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg,reportId);
		}
	

//	@GetMapping("/fetch/report/{reportId}")
//	public ResponseEntity<ResponseMessage> getReportById(@PathVariable(value = "reportId") Long reportId) {
//		ReportDto response = null;
//		try {
//			response = reportservices.getReportById(reportId);
//			if (response == null) {
//				errorMessage = NO_RECORD_FOUND;
//			}
//		} catch (Exception e) {
//			errorMessage = JSON_PROCESSING_FAILED;
//			exceptionMsg = e.getMessage();
//		}
//
//		return processResponse(errorMessage, exceptionMsg, response);
//
//	}
//	
	@GetMapping("/fetch/reportName/{reportName}")
	public ResponseEntity<ResponseMessage> getReportByName(@PathVariable(value ="reportName") String reportName){
		ReportDto response = null;
		try {
			response = reportservices.getReportByReportName(reportName);
			// System.out.print(response);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

}
