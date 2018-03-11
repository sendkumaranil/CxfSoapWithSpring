package com.cxfsoap.example.dao;

import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;

public interface MoryaAirlinesDao {

	public FlightDetailsResponse getFlightDetails(FlightDetailsRequest request);

	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request);

}
