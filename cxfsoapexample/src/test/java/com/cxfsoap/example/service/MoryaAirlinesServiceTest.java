package com.cxfsoap.example.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.cxfsoap.example.dao.MoryaAirlinesDao;
import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetails;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;
import com.itextpdf.text.DocumentException;

@RunWith(MockitoJUnitRunner.class)
public class MoryaAirlinesServiceTest {

	@InjectMocks
	private MoryaAirlinesService subject;
	
	@Mock
	private MoryaAirlinesDao daoService;
	
	@Test
	public void getFlightDetailsTest() throws ParseException {
		FlightDetailsRequest request=new FlightDetailsRequest();
		FlightDetails flightDetail=new FlightDetails();
		flightDetail.setFlightId("MORBANGDEL001");
		flightDetail.setFlightName("MORYABANGALOREDELHI");
		flightDetail.setSource("BANGALORE");
		flightDetail.setDestination("DELHI");
		flightDetail.setDepartDate("24-06-2018");
		flightDetail.setDepTime("05:30");
		flightDetail.setArriveTime("08:30");
		flightDetail.setTotalFare(new BigDecimal("5775.00"));
		flightDetail.setTotalStop(1);
		List<String> stopages=new ArrayList<>();
		stopages.add("KOLKATA");
		flightDetail.setStopageAirports(stopages);
		List<FlightDetails> flightDetails=new ArrayList<>();
		flightDetails.add(flightDetail);
		when(daoService.getFlightDetails(request)).thenReturn(flightDetails);
		FlightDetailsResponse response=subject.getFlightDetails(request);
		
		assertNotNull(response);
	}
	@Test
	public void getFlightDetails24HrsTest() throws ParseException {
		FlightDetailsRequest request=new FlightDetailsRequest();
		FlightDetails flightDetail=new FlightDetails();
		flightDetail.setFlightId("MORBANGDEL001");
		flightDetail.setFlightName("MORYABANGALOREDELHI");
		flightDetail.setSource("BANGALORE");
		flightDetail.setDestination("DELHI");
		flightDetail.setDepartDate("24-06-2018");
		flightDetail.setDepTime("05:30");
		flightDetail.setArriveTime("24:30");
		flightDetail.setTotalFare(new BigDecimal("5775.00"));
		flightDetail.setTotalStop(1);
		List<String> stopages=new ArrayList<>();
		stopages.add("KOLKATA");
		flightDetail.setStopageAirports(stopages);
		List<FlightDetails> flightDetails=new ArrayList<>();
		flightDetails.add(flightDetail);
		when(daoService.getFlightDetails(request)).thenReturn(flightDetails);
		FlightDetailsResponse response=subject.getFlightDetails(request);
		
		assertNotNull(response);
	}
	@Test(expected=ParseException.class)
	public void getFlightDetailsExceptionTest() throws ParseException {
		FlightDetailsRequest request=new FlightDetailsRequest();
		FlightDetails flightDetail=new FlightDetails();
		flightDetail.setFlightId("MORBANGDEL001");
		flightDetail.setFlightName("MORYABANGALOREDELHI");
		flightDetail.setSource("BANGALORE");
		flightDetail.setDestination("DELHI");
		flightDetail.setDepartDate("24-06-2018");
		flightDetail.setDepTime("05");
		flightDetail.setArriveTime("08:30");
		flightDetail.setTotalFare(new BigDecimal("5775.00"));
		flightDetail.setTotalStop(1);
		List<String> stopages=new ArrayList<>();
		stopages.add("KOLKATA");
		flightDetail.setStopageAirports(stopages);
		List<FlightDetails> flightDetails=new ArrayList<>();
		flightDetails.add(flightDetail);
		when(daoService.getFlightDetails(request)).thenReturn(flightDetails);
		FlightDetailsResponse response=subject.getFlightDetails(request);
		
		assertNotNull(response);
	}
	
	@Test
	public void getBookingDetailsTest() throws ParseException, DocumentException, IOException {
		BookingDetailsRequest request=new BookingDetailsRequest();
		BookingDetailsResponse result=new BookingDetailsResponse();
		result.setFlightId("MORBANGDEL001");
		result.setFlightName("MORYABANGALOREDELHI");
		result.setBookingDate("18-03-2018");
		result.setArrivalTime("08:30");
		result.setDeptTime("05:30");
		
		when(daoService.checkBookingExists(request)).thenReturn(1);
		when(daoService.getBookingDetails(request)).thenReturn(result);
		
		BookingDetailsResponse response=subject.getBookingDetails(request);
		
		assertNotNull(response);
	}
	/*@Test
	public void getBookingDetailsNewRecordTest() throws ParseException, DocumentException, IOException {
		BookingDetailsRequest request=new BookingDetailsRequest();
		BookingDetailsResponse result=new BookingDetailsResponse();
		result.setFlightId("MORBANGDEL001");
		result.setFlightName("MORYABANGALOREDELHI");
		result.setBookingDate("18-03-2018");
		result.setArrivalTime("08:30");
		result.setDeptTime("05:30");
		
		MoryaAirlinesDao mockvoid=Mockito.mock(MoryaAirlinesDao.class);
		when(daoService.checkBookingExists(request)).thenReturn(0);
		doNothing().when(mockvoid).updateBookingDetail(request);//void method stubbing
		when(daoService.getBookingDetails(request)).thenReturn(result);
		
		BookingDetailsResponse response=subject.getBookingDetails(request);
		verify(mockvoid,times(1)).updateBookingDetail(request);
		assertNotNull(response);
	}*/
	@Test
	public void getBookingDetails24HrsTest() throws ParseException, DocumentException, IOException {
		BookingDetailsRequest request=new BookingDetailsRequest();
		BookingDetailsResponse result=new BookingDetailsResponse();
		result.setFlightId("MORBANGDEL001");
		result.setFlightName("MORYABANGALOREDELHI");
		result.setBookingDate("18-03-2018");
		result.setArrivalTime("24:30");
		result.setDeptTime("05:30");
		
		when(daoService.checkBookingExists(request)).thenReturn(1);
		when(daoService.getBookingDetails(request)).thenReturn(result);
		
		BookingDetailsResponse response=subject.getBookingDetails(request);
		
		assertNotNull(response);
	}
	@Test(expected=ParseException.class)
	public void getBookingDetailsExceptionTest() throws ParseException, DocumentException, IOException {
		BookingDetailsRequest request=new BookingDetailsRequest();
		BookingDetailsResponse result=new BookingDetailsResponse();
		result.setFlightId("MORBANGDEL001");
		result.setFlightName("MORYABANGALOREDELHI");
		result.setBookingDate("18-03-2018");
		result.setArrivalTime("08");
		result.setDeptTime("05:30");
		
		when(daoService.checkBookingExists(request)).thenReturn(1);
		when(daoService.getBookingDetails(request)).thenReturn(result);
		
		BookingDetailsResponse response=subject.getBookingDetails(request);
		
		assertNotNull(response);
	}
}
