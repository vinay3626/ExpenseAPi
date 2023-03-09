package com.tecnics.expense.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.validation.constraints.AssertFalse;
// import javax.validation.constraints.AssertTrue;
// import javax.validation.constraints.NotNull;

// import org.springframework.beans.factory.annotation.Value;

import com.tecnics.expense.utils.*;

@Entity
@Table(name = "expense_table")
public class ExpenseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long expenseId;

	private Date date;

	private String merchant;

	private String category;
	
	private String currency;

	private int amount;

	private String description;

	private status status;

	private boolean isActionTaken;

	private String rejectReason;	

	private String rejectDescription;

	private Timestamp created;

	private Timestamp updated;
	
	

	@Override
	public String toString() {
		return "ExpenseModel [expenseId=" + expenseId + ", date=" + date + ", merchant=" + merchant + ", category="
				+ category + ", currency=" + currency + ", amount=" + amount + ", description=" + description
				+ ", status=" + status + ", isActionTaken=" + isActionTaken + ", rejectReason=" + rejectReason
				+ ", rejectDescription=" + rejectDescription + ", created=" + created + ", updated=" + updated + "]";
	}

	public ExpenseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenseModel(long expenseId, Date date, String merchant, String category, int amount, String currency, 
	 String description, status status,String rejectReason,String rejectDescription,Boolean isActionTaken,
			Timestamp created, Timestamp updated) { 
		super();
		this.expenseId = expenseId;
		this.date = date;
		this.merchant = merchant;
		this.category = category;
		this.amount = amount;
		this.description = description;
		this.currency = currency;
		this.status = status;
		this.isActionTaken = isActionTaken;
		this.rejectDescription = rejectDescription;
		this.rejectReason = rejectReason;
		this.created = created;
		this.updated = updated;
	}

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
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public boolean isIsActionTaken() {
		return isActionTaken;
	}

	public void setIsactionTaken(boolean isActionTaken) {
		this.isActionTaken = isActionTaken;
	}

	





}
