package com.tecnics.expense.dtos;

import java.sql.Timestamp;
import java.util.Date;
import com.tecnics.expense.utils.*;

public class ExpenseDto {

	private long expenseId;
	
	private Date date;
	
	private String merchant;
	
	private String category;
	
	private int amount;
	
	private String currency;
	
	private String description;

	private status status;

	private String rejectReason;

	private String rejectDescription;

	private boolean isActionTaken;

	
	private Timestamp created;
	
 	private Timestamp updated;

	public long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(status status) {
		this.status = status;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getRejectDescription() {
		return rejectDescription;
	}

	public void setRejectDescription(String rejectDescription) {
		this.rejectDescription = rejectDescription;
	}

	public boolean isActionTaken() {
		return isActionTaken;
	}

	public void setActionTaken(boolean isActionTaken) {
		this.isActionTaken = isActionTaken;
	}

	
 	
 	
 	

}
