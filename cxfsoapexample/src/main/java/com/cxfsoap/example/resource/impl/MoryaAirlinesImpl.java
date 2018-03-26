package com.cxfsoap.example.resource.impl;

import java.io.IOException;
import java.text.ParseException;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;
import com.cxfsoap.example.resource.MoryaAirlines;
import com.cxfsoap.example.service.MoryaAirlinesService;
import com.cxfsoap.example.util.MoryaAirlinesValidator;
import com.itextpdf.text.DocumentException;

@WebService(endpointInterface="com.cxfsoap.example.resource.MoryaAirlines",
targetNamespace="http://cxfsoap.moryaairlines.com/")
public class MoryaAirlinesImpl implements MoryaAirlines {

	
	@Autowired
	private MoryaAirlinesService service;
	@Autowired
	private MoryaAirlinesValidator validator;
	
	public FlightDetailsResponse getFlightDetails(FlightDetailsRequest request) throws ParseException {	
		
		FlightDetailsResponse validateResponse=validator.validateSourceDestination(request);
		if(validateResponse != null) {
			return validateResponse;
		}
		return service.getFlightDetails(request);
	}

	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request) throws ParseException, DocumentException, IOException {
		BookingDetailsResponse validateResponse=validator.validateBookingDetails(request);
		if(validateResponse != null) {
			return validateResponse;
		}
		return service.getBookingDetails(request);
	}
}
