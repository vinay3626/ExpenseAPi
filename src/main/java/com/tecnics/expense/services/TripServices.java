package com.tecnics.expense.services;

import java.util.List;

import com.tecnics.expense.dtos.TripDto;

public interface TripServices {

public List<TripDto> getAllTrips();
	
	public TripDto submitTrip(TripDto expenseDto);
	
	public TripDto updateTrip(TripDto expenseDto, long tripId);

	public void deleteTrip(Long expId);

	public TripDto saveTrip(TripDto tripDto);

	public TripDto approveTrip(TripDto tripDto,long tripId);

	public TripDto rejectTrip(TripDto tripDto, long tripId);

}
