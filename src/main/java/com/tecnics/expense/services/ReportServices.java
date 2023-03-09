package com.tecnics.expense.services;

import java.util.List;

import com.tecnics.expense.dtos.ReportDto;

public interface ReportServices {
	
	public List<ReportDto> getReportDetails();

	public ReportDto getReportByReportName(String reportName);

	public ReportDto createReport(ReportDto report);

	public ReportDto updateReport(ReportDto report,long reportId);

	public void deleteReport(Long reportId);


}
