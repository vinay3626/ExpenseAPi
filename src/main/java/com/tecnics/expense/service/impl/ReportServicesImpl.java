package com.tecnics.expense.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expense.dtos.ReportDto;
import com.tecnics.expense.models.ReportModel;
import com.tecnics.expense.repositories.ReportRepository;
import com.tecnics.expense.services.ReportServices;

@Service
public class ReportServicesImpl implements ReportServices {

	@Autowired
	private ReportRepository reportrepo;
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<ReportDto> getReportDetails() {
		List<ReportDto> ReportDto = new ArrayList<ReportDto>();
		reportrepo.findAll().forEach(ReportModel -> ReportDto.add(modelMapper.map(ReportModel, ReportDto.class)));

		return ReportDto;
	}

	@Override
	public ReportDto createReport(ReportDto report) {
		return modelMapper.map
				(reportrepo.save(modelMapper.map(report, ReportModel.class)), ReportDto.class);

	}

	@Override
	public ReportDto updateReport(ReportDto reportDto,long reportId) {
		ReportModel reportModel = reportrepo.findByReportId(reportId);
		if(reportModel != null) {
			if(reportDto.getReportName() != null) {
				reportModel.setReportName(reportDto.getReportName());
			}
			if(reportDto.getDate() != null) {
				reportModel.setDate(reportDto.getDate());
				
			}
			if(reportDto.getDescription() != null) {
				reportModel.setDescription(reportDto.getDescription());
			}
			
			reportModel.setUpdated(new Timestamp(0));

//			}if(reportDto.getStatus() != null) {
//				reportModel.setStatus(reportDto.getStatus());
//			}if(reportDto.getDuration() != null) {
//				reportModel.setDuration(reportDto.getDuration());
			reportrepo.save(reportModel);
			return modelMapper.map(reportModel, ReportDto.class);
			
		}else return null;
	}

	@Override
	public void deleteReport(Long reportId) {
		reportrepo.deleteById(reportId);
		
	}

	@Override
	public ReportDto getReportByReportName(String reportName) {

		ReportModel reportModel = reportrepo.findByReportName(reportName);

		return modelMapper.map(reportModel,ReportDto.class);
		
	}

}
