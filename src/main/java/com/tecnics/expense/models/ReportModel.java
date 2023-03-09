package com.tecnics.expense.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "report_table")
public class ReportModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;

	private String reportName;

	private Date date;

	//	private Status status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Fk_reportId",referencedColumnName = "reportId")
	private List<ExpenseModel> Expenses;

	private String description;

	private Long total;


	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;
	

	public ReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	
	public List<ExpenseModel> getExpenses() {
		return Expenses;
	}

	public void setExpenses(List<ExpenseModel> expenses) {
		Expenses = expenses;
	}
	
	

}
