package com.cxfsoap.example.resource;

import java.text.ParseException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;

@WebService
public interface MoryaAirlines {

	@WebMethod
	public FlightDetailsResponse getFlightDetails(FlightDetailsRequest request) throws ParseException;
	
	@WebMethod
	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request) throws ParseException;
}
