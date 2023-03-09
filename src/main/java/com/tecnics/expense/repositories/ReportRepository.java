package com.tecnics.expense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnics.expense.models.ReportModel;

@Repository
public interface ReportRepository  extends JpaRepository<ReportModel, Long> {
	
	List<ReportModel> findAll();
	
	ReportModel findByReportId(Long ReportId);

	ReportModel findByReportName(String reportName);

}
