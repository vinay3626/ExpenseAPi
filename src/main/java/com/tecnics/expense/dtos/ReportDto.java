package com.tecnics.expense.dtos;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.tecnics.expense.models.ExpenseModel;

public class ReportDto {
	
	private Long reportId;
	
	private String reportName;

	private Date date;

	private List<ExpenseModel> Expenses;

//	private Status status;

	private String description;
	
	private Long total;

	

	private Timestamp created;

	private Timestamp updated;

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ExpenseModel> getExpenses() {
		return Expenses;
	}

	public void setExpenses(List<ExpenseModel> expenses) {
		Expenses = expenses;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
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

	
}
