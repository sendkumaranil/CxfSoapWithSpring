package com.cxfsoap.example.resource.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;
import com.cxfsoap.example.service.MoryaAirlinesService;
import com.cxfsoap.example.util.MoryaAirlinesValidator;
import com.itextpdf.text.DocumentException;

@RunWith(MockitoJUnitRunner.class)
public class MoryaAirlinesImplTest {

	@InjectMocks
	private MoryaAirlinesImpl subject;
	
	@Mock
	private MoryaAirlinesValidator validator;
	
	@Mock
	private MoryaAirlinesService service;
	
	@Test
	public void getFlightDetailsTest() throws ParseException {
		FlightDetailsRequest request=new FlightDetailsRequest();
		FlightDetailsResponse result=new FlightDetailsResponse();
		when(validator.validateSourceDestination(request)).thenReturn(null);
		when(service.getFlightDetails(request)).thenReturn(result);
		FlightDetailsResponse response=subject.getFlightDetails(request);
		assertNotNull(response);
	}
	@Test
	public void getFlightDetailsValidationFailedTest() throws ParseException {
		FlightDetailsRequest request=new FlightDetailsRequest();
		FlightDetailsResponse result=new FlightDetailsResponse();
		when(validator.validateSourceDestination(request)).thenReturn(result);		
		FlightDetailsResponse response=subject.getFlightDetails(request);
		assertNotNull(response);
	}
	@Test
	public void getBookingDetailsTest() throws ParseException, DocumentException, IOException {
		BookingDetailsRequest request=new BookingDetailsRequest();
		BookingDetailsResponse result=new BookingDetailsResponse();
		when(validator.validateBookingDetails(request)).thenReturn(null);
		when(service.getBookingDetails(request)).thenReturn(result);
		BookingDetailsResponse response=subject.getBookingDetails(request);
		assertNotNull(response);
	}
	@Test
	public void getBookingDetailsValidationFailedTest() throws ParseException, DocumentException, IOException {
		BookingDetailsRequest request=new BookingDetailsRequest();
		BookingDetailsResponse result=new BookingDetailsResponse();
		when(validator.validateBookingDetails(request)).thenReturn(result);		
		BookingDetailsResponse response=subject.getBookingDetails(request);
		assertNotNull(response);
	}
}
