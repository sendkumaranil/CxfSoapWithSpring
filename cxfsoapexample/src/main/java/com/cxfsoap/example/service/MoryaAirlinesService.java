package com.cxfsoap.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxfsoap.example.dao.MoryaAirlinesDao;
import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;

@Service
public class MoryaAirlinesService {

	@Autowired
	private MoryaAirlinesDao daoService;
	
	public FlightDetailsResponse getFlightDetails(FlightDetailsRequest request) {
		return daoService.getFlightDetails(request);
	}

	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request) {
		return daoService.getBookingDetails(request);
	}
}
