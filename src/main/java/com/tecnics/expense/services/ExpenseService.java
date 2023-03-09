package com.tecnics.expense.services;

import java.util.List;

import com.tecnics.expense.dtos.ExpenseDto;

public interface ExpenseService {

	public List<ExpenseDto> getAllExpenses();

	public ExpenseDto getExpenseByMerchant(String expenseName);
	
	public ExpenseDto submitExpense(ExpenseDto expenseDto);
	
	public ExpenseDto updateExpense(ExpenseDto expenseDto, long expId);

	public void deleteExpense(Long expId);

	public ExpenseDto saveExpense(ExpenseDto expenseDto);

	public ExpenseDto approveExpense(ExpenseDto expenseDto,long expenseId);

	public ExpenseDto rejectExpenses(ExpenseDto expenseDto,long expenseId);

	


}
