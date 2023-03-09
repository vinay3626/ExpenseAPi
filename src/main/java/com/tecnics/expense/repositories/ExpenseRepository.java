package com.tecnics.expense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnics.expense.models.ExpenseModel;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {
	
	 List<ExpenseModel> findAll();
	 
	 ExpenseModel findByExpenseId(Long expId);

	 ExpenseModel findExpenseByMerchant(String expenseName);
	
}
