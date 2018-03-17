package com.cxfsoap.example.dao;

import java.util.List;

import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetails;

public interface MoryaAirlinesDao {

	public List<FlightDetails> getFlightDetails(FlightDetailsRequest request);
	public void updateBookingDetail(BookingDetailsRequest request);
	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request);
	public List<String> fetchAllSources();
	public List<String> fetchAllDestination();
}
