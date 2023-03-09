package com.tecnics.expense.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expense.dtos.TripDto;
import com.tecnics.expense.models.TripModel;
import com.tecnics.expense.repositories.TripRepository;
import com.tecnics.expense.services.TripServices;
import com.tecnics.expense.utils.status;

@Service
public class TripServicesImpl implements TripServices {

	@Autowired
	private TripRepository tripRepo;
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<TripDto> getAllTrips() {
		List<TripDto> tripDto = new ArrayList<TripDto>();
		tripRepo.findAll().forEach(tripModel -> tripDto.add(modelMapper.map(tripModel, TripDto.class)));
		return tripDto;
	}

	@Override
	public TripDto submitTrip(TripDto tripDto) {
		tripDto.setStatus(status.SUBMITTED);
		return modelMapper.map(tripRepo.save(modelMapper.map(tripDto, TripModel.class)), TripDto.class);
	}

	@Override
	public TripDto updateTrip(TripDto tripDto, long tripId) {
		TripModel TripModel = tripRepo.findByTripId(tripId);
		if (TripModel != null) {
			
			if (tripDto.getTripName() != null) {
				TripModel.setTripName(tripDto.getTripName());
			}
			if(tripDto.getFromDate() != null) {
				TripModel.setFromDate(tripDto.getFromDate());
			}
			
			if(tripDto.getToDate() != null) {
				TripModel.setToDate(tripDto.getToDate());
			}
			
			if (tripDto.getFromLocation() != null) {
				TripModel.setFromLocation(tripDto.getFromLocation());
			}
			if (tripDto.getToLocation() != null) {
				TripModel.setToLocation(tripDto.getToLocation());
			}

			if(tripDto.getDescription() != null) {
				TripModel.setDescription(tripDto.getDescription());
			}

			if(tripDto.getStatus() != null) {
				TripModel.setStatus(tripDto.getStatus());
			}


			TripModel.setUpdated(new Timestamp(0));
			tripRepo.save(TripModel);
			return modelMapper.map(TripModel, TripDto.class);
		} else
			return null;
	}

	@Override
	public void deleteTrip(Long tripId) {
		tripRepo.deleteById(tripId);

		
	}

	@Override
	public TripDto approveTrip(TripDto tripDto,long tripId) {

		TripModel tripModel = tripRepo.findByTripId(tripId);

		tripModel.setIsActionTaken(true);
		tripModel.setStatus(status.APPROVED);

		tripRepo.save(tripModel);

		return modelMapper.map(tripModel, TripDto.class);
	}

	@Override
	public TripDto rejectTrip(TripDto tripDto, long tripId){

		TripModel tripModel = tripRepo.findByTripId(tripId);
		
		tripModel.setIsActionTaken(true);
		tripModel.setStatus(status.REJECTED);

		tripRepo.save(tripModel);

		return modelMapper.map(tripModel, TripDto.class);
	}

	@Override
	public TripDto saveTrip(TripDto tripDto) {


		TripModel tripModel = modelMapper.map(tripDto,TripModel.class);

		tripModel.setStatus(status.SAVED);
		tripRepo.save(tripModel);
		

		return modelMapper.map(tripModel,TripDto.class);
	}

}
