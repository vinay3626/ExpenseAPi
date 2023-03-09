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

import com.tecnics.expense.dtos.ExpenseDto;
import com.tecnics.expense.services.ExpenseService;
import com.tecnics.expense.utils.ResponseMessage;

@RestController
@CrossOrigin("*")
public class ExpenseController {
	
	String errorMessage = null;
	String exceptionMsg = null;
	
	@Autowired
	public ExpenseService expenseService;

	//@CrossOrigin(origins="https://localhost:4200")
	@GetMapping("/fetch/expenses")
	public ResponseEntity<ResponseMessage> getAllExpenses() {
		List<ExpenseDto> response = null;
		try {
			response = expenseService.getAllExpenses();
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
	
	@PostMapping("/submit/expense")
	public ResponseEntity<ResponseMessage> submitExpense(@RequestBody ExpenseDto expenseDto) {
		ExpenseDto response = null;
		try {
			response = expenseService.submitExpense(expenseDto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/expense/{expId}")
	public ResponseEntity<ResponseMessage> updateExpense(@RequestBody ExpenseDto expenseDto, @PathVariable(value = "expId") Long expId) {
		ExpenseDto response = null;
		try {
			response = expenseService.updateExpense(expenseDto,expId);
			
		}catch(DataIntegrityViolationException e){
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		}catch(Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage,exceptionMsg,response);
	}

	@DeleteMapping("delete/expense/{expId}")
	public ResponseEntity<ResponseMessage> deleteExpense(@PathVariable(value = "expId") Long expId) {
		try{expenseService.deleteExpense(expId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			expId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			expId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg, expId);

		}

		@GetMapping("fetch/merchant/{merchant}")
		public ResponseEntity<ResponseMessage> getExpenseByMerchant(@PathVariable(value = "merchant" ) String merchant){
				ExpenseDto response = null;
			try{
				response = expenseService.getExpenseByMerchant(merchant);
				
				if(response == null){
					errorMessage = NO_RECORD_FOUND;
				}
			}
			catch(Exception e){
				errorMessage = JSON_PROCESSING_FAILED;
				exceptionMsg = e.getMessage();
			}



			return processResponse(errorMessage, exceptionMsg, response);
		}


		@PostMapping("expense/approve/{expenseId}")
		public ResponseEntity<ResponseMessage> approveExpense(@RequestBody ExpenseDto expenseDto,@PathVariable(value = "expenseId") long expenseId){
				ExpenseDto response = null;
				try{
					response =	expenseService.approveExpense(expenseDto,expenseId);
				} catch (Exception e) {
					errorMessage = JSON_PROCESSING_FAILED;
					exceptionMsg = e.getMessage();
				}
			return processResponse(errorMessage, exceptionMsg, response);
		}

		@PostMapping("expense/reject/{expenseId}")
		public ResponseEntity<ResponseMessage> rejectExpense(@RequestBody ExpenseDto expenseDto,@PathVariable(value="expenseId") long expenseId){
			
			ExpenseDto response = null;
			try{
				response = expenseService.rejectExpenses(expenseDto, expenseId);
			}
			catch(Exception e){
					errorMessage = JSON_PROCESSING_FAILED;
					exceptionMsg = e.getMessage();
			}
					return processResponse(errorMessage, exceptionMsg, response);
		}

		@PostMapping("save/expense")
		public ResponseEntity<ResponseMessage> saveExpense(@RequestBody ExpenseDto expenseDto){

			ExpenseDto response = null;
			try
			{
				response = expenseService.saveExpense(expenseDto);
			}catch(DataIntegrityViolationException e){
				errorMessage = RECORD_IS_ALREADY_EXIST;
				exceptionMsg = e.getMessage();

			}catch(Exception e){
				errorMessage = JSON_PROCESSING_FAILED;
				exceptionMsg = e.getMessage();
			}
			return processResponse(errorMessage, exceptionMsg, response);
		}


}
