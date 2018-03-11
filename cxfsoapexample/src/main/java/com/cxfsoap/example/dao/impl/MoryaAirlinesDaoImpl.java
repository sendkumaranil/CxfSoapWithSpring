package com.cxfsoap.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cxfsoap.example.dao.MoryaAirlinesDao;
import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;

@Repository
public class MoryaAirlinesDaoImpl  implements MoryaAirlinesDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public FlightDetailsResponse getFlightDetails(FlightDetailsRequest request) {
		
		return null;
	}

	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request) {
		return null;
	}
}
