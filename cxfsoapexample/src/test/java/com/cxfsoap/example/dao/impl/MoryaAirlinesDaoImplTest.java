package com.cxfsoap.example.dao.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cxfsoap.example.mappers.FlightDetailsRowMapper;
import com.cxfsoap.example.mappers.SourcesDestinationMapper;
import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.FlightDetails;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.PassengerList;

@RunWith(MockitoJUnitRunner.class)
public class MoryaAirlinesDaoImplTest {

	@InjectMocks
	private MoryaAirlinesDaoImpl subject;
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void getFlightDetailsTest() {
		FlightDetailsRequest request=new FlightDetailsRequest();
		request.setSource("delhi");
		request.setDestination("bangalore");
		request.setDepartDate("24-06-2018");
		Object[] params=new Object[] {
				"DELHI",
				"BANGALORE"
			};
		List<FlightDetails> flightDetails=new ArrayList<>();
		when(jdbcTemplate.query("sql query", params, new FlightDetailsRowMapper())).thenReturn(flightDetails);
		List<FlightDetails> response=subject.getFlightDetails(request);
		assertNotNull(response);
	}
	@Test
	public void updateBookingDetailTest() {
		PassengerList passengerList=new PassengerList();
		List<String> passengers=new ArrayList<>();
		passengers.add("Anil");
		passengers.add("Mayank");
		passengerList.setName(passengers);
		BookingDetailsRequest request=new BookingDetailsRequest();
		request.setFlightId("FLIGHTID");
		request.setDepartDate("24-06-2018");
		request.setGovtIdentityId("AB1200");
		request.setGovtIdentityType("ABC");
		request.setNoOfAdults(2);
		request.setNoOfChildren(0);
		BigDecimal totalFare=new BigDecimal("9775.00");
		request.setTotalFare(totalFare);
		request.setTravelClass("XYZ");
		request.setPassengerList(passengerList);
		
		Object[] params=new Object[] {
				request.getFlightId(),
				request.getDepartDate()				
		};		
		
		when(jdbcTemplate.update("sql query", params)).thenReturn(1);		
		when(jdbcTemplate.update("sql query", 10,"FLIGHTId")).thenReturn(1);
		when(jdbcTemplate.queryForObject(anyString(), anyObject(), eq(Integer.class))).thenReturn(1);
		subject.updateBookingDetail(request);
	}
	
	@Test
	public void fetchAllSourcesTest() {
		List<String> sources=new ArrayList<>();
		when(jdbcTemplate.query("sql query", new SourcesDestinationMapper())).thenReturn(sources);
		List<String> response=subject.fetchAllSources();
		assertNotNull(response);
	}
	@Test
	public void fetchAllDestinationTest() {
		List<String> destinations=new ArrayList<>();
		when(jdbcTemplate.query("sql query", new SourcesDestinationMapper())).thenReturn(destinations);
		List<String> response=subject.fetchAllDestination();
		assertNotNull(response);
	}
	@Test
	public void validateFlightIdTest() {
		BookingDetailsRequest request=new BookingDetailsRequest();
		when(jdbcTemplate.queryForObject(anyString(), anyObject(), eq(Integer.class))).thenReturn(1);
		int value=subject.validateFlightId(request);
		assertEquals(1, value);
	}
	@Test
	public void checkBookingExistsTest() {
		BookingDetailsRequest request=new BookingDetailsRequest();
		when(jdbcTemplate.queryForObject(anyString(), anyObject(), eq(Integer.class))).thenReturn(1);
		int value=subject.checkBookingExists(request);
		assertEquals(1, value);
	}
}
