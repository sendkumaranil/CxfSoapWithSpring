package com.cxfsoap.example.resource.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;
import com.cxfsoap.example.resource.MoryaAirlines;
import com.cxfsoap.example.service.MoryaAirlinesService;

@WebService(endpointInterface="com.cxfsoap.example.resource.MoryaAirlines",
targetNamespace="http://cxfsoap.moryaairlines.com/")
public class MoryaAirlinesImpl implements MoryaAirlines {

	@Autowired
	private MoryaAirlinesService service;
	
	public FlightDetailsResponse getFlightDetails(FlightDetailsRequest request) {		
		return service.getFlightDetails(request);
	}

	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request) {
		return service.getBookingDetails(request);
	}
}
