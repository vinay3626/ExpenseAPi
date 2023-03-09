package com.tecnics.expense.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expense.dtos.ExpenseDto;
import com.tecnics.expense.models.ExpenseModel;
import com.tecnics.expense.repositories.ExpenseRepository;
import com.tecnics.expense.services.ExpenseService;
import com.tecnics.expense.utils.status;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;

	ModelMapper modelMapper = new ModelMapper();
	
	@Override	
	public List<ExpenseDto> getAllExpenses() {
		List<ExpenseDto> expenseDto = new ArrayList<ExpenseDto>();
		expenseRepo.findAll().forEach(expenseModel -> expenseDto.add(modelMapper.map(expenseModel, ExpenseDto.class)));
		return expenseDto;
	}

	@Override
	public ExpenseDto submitExpense(ExpenseDto expenseDto) {

		expenseDto.setStatus(status.SUBMITTED);

		return 
		modelMapper.map(
			expenseRepo.save(
			modelMapper.map(expenseDto, ExpenseModel.class)),
			 ExpenseDto.class);

	}

	@Override
	public ExpenseDto updateExpense(ExpenseDto expenseDto,long expId) {
		ExpenseModel expenseModel = expenseRepo.findByExpenseId(expId);
		if (expenseModel != null) {
			
			if(expenseDto.getDate() != null) {
				expenseModel.setDate(expenseDto.getDate());
			}
			if (expenseDto.getMerchant() != null) {
				expenseModel.setMerchant(expenseDto.getMerchant());
			}
			if (expenseDto.getAmount() != 0) {
				expenseModel.setAmount(expenseDto.getAmount());
			}
			if (expenseDto.getCurrency() != null) {
				expenseModel.setCurrency(expenseDto.getCurrency());
			}
			if(expenseDto.getDescription() != null) {
				expenseModel.setDescription(expenseDto.getDescription());
			}
			if(expenseDto.getStatus() != null){
				expenseModel.setStatus(expenseDto.getStatus());
			}
			expenseModel.setUpdated(new Timestamp(0));
			expenseRepo.save(expenseModel);
			return modelMapper.map(expenseModel, ExpenseDto.class);
		} else
			return null;	}

	@Override
	public void deleteExpense(Long expId) {
		expenseRepo.deleteById(expId);

	}

	@Override
	public ExpenseDto getExpenseByMerchant(String expenseName) {

		ExpenseModel expenseModel = expenseRepo.findExpenseByMerchant(expenseName);

		return	modelMapper.map(expenseModel,ExpenseDto.class);
	}

	@Override
	public ExpenseDto approveExpense(ExpenseDto expenseDto,long expenseId) {

		ExpenseModel expenseModel = expenseRepo.findByExpenseId(expenseId);

		expenseModel.setIsactionTaken(true);
		expenseModel.setStatus(status.APPROVED);

		expenseRepo.save(expenseModel);

		return modelMapper.map(expenseModel,ExpenseDto.class);
	}

	@Override
	public ExpenseDto rejectExpenses(ExpenseDto expenseDto, long expenseId) {
			ExpenseModel expenseModel = expenseRepo.findByExpenseId(expenseId);

			expenseModel.setIsactionTaken(true);
			expenseModel.setStatus(status.REJECTED);
			expenseModel.setRejectReason(expenseDto.getRejectReason());
			expenseModel.setRejectDescription(expenseDto.getRejectDescription());

		expenseRepo.save(expenseModel);

		
		return modelMapper.map(expenseModel,ExpenseDto.class);
	}

	@Override
	public ExpenseDto saveExpense(ExpenseDto expenseDto) {

		ExpenseModel expenseModel = modelMapper.map(expenseDto,ExpenseModel.class);

		expenseModel.setStatus(status.SAVED);
		expenseRepo.save(expenseModel);

		return modelMapper.map(expenseModel,ExpenseDto.class);
	}
}
