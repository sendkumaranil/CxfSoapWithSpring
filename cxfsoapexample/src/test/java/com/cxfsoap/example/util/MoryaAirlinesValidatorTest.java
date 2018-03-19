package com.cxfsoap.example.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cxfsoap.example.dao.MoryaAirlinesDao;
import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;

@RunWith(MockitoJUnitRunner.class)
public class MoryaAirlinesValidatorTest {

	@InjectMocks
	private MoryaAirlinesValidator subject;
	
	@Mock
	private MoryaAirlinesDao daoService;
	
	@Test
	public void validateSourceDestinationSameSourceDestinationTest() {
		FlightDetailsRequest request=new FlightDetailsRequest();
		request.setSource("bangalore");
		request.setDestination("bangalore");
		FlightDetailsResponse response=subject.validateSourceDestination(request);
		assertNotNull(response);
	}
	@Test
	public void validateSourceDestinationTest() {
		FlightDetailsRequest request=new FlightDetailsRequest();
		request.setSource("delhi");
		request.setDestination("bangalore");
		request.setDepartDate("24-06-2018");
		List<String> sources=new ArrayList<>();
		sources.add("DELHI");		
		List<String> destinations=new ArrayList<>();
		destinations.add("BANGALORE");
		when(daoService.fetchAllSources()).thenReturn(sources);
		when(daoService.fetchAllDestination()).thenReturn(destinations);
		FlightDetailsResponse response=subject.validateSourceDestination(request);
		assertNull(response);
	}
	@Test
	public void validateSourceDestinationValidationFailedTest() {
		FlightDetailsRequest request=new FlightDetailsRequest();
		request.setSource("delhi");
		request.setDestination("bangalore");
		request.setDepartDate("24-06-2018");
		List<String> sources=new ArrayList<>();
		sources.add("MUMBAI");		
		List<String> destinations=new ArrayList<>();
		destinations.add("BANGALORE");
		when(daoService.fetchAllSources()).thenReturn(sources);
		when(daoService.fetchAllDestination()).thenReturn(destinations);
		FlightDetailsResponse response=subject.validateSourceDestination(request);
		assertNotNull(response);
	}
	
	@Test
	public void validateSourceDestinationInvalidDateTest() {
		FlightDetailsRequest request=new FlightDetailsRequest();
		request.setSource("delhi");
		request.setDestination("bangalore");
		request.setDepartDate("24/06/2018");
		List<String> sources=new ArrayList<>();
		sources.add("DELHI");		
		List<String> destinations=new ArrayList<>();
		destinations.add("BANGALORE");
		when(daoService.fetchAllSources()).thenReturn(sources);
		when(daoService.fetchAllDestination()).thenReturn(destinations);
		FlightDetailsResponse response=subject.validateSourceDestination(request);
		assertNotNull(response);
	}
	
	@Test
	public void validateBookingDetailsTest() {
		BookingDetailsRequest request=new BookingDetailsRequest();
		request.setDepartDate("24-06-2018");
		when(daoService.validateFlightId(request)).thenReturn(1);
		BookingDetailsResponse response=subject.validateBookingDetails(request);
		assertNull(response);
	}
	@Test
	public void validateBookingDetailsInvalidDateTest() {
		BookingDetailsRequest request=new BookingDetailsRequest();
		request.setDepartDate("24/06/2018");		
		BookingDetailsResponse response=subject.validateBookingDetails(request);
		assertNotNull(response);
	}
	@Test
	public void validateBookingDetailsInvalidRecordTest() {
		BookingDetailsRequest request=new BookingDetailsRequest();
		request.setDepartDate("24-06-2018");
		when(daoService.validateFlightId(request)).thenReturn(0);
		BookingDetailsResponse response=subject.validateBookingDetails(request);
		assertNotNull(response);
	}
}
