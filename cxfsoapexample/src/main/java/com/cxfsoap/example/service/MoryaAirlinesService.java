package com.cxfsoap.example.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxfsoap.example.dao.MoryaAirlinesDao;
import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;
import com.cxfsoap.example.model.FlightDetails;

@Service
public class MoryaAirlinesService {	
	private DateFormat formatter = new SimpleDateFormat("HH:mm");
	
	@Autowired
	private MoryaAirlinesDao daoService;
	
	public FlightDetailsResponse getFlightDetails(FlightDetailsRequest request) {
		
		FlightDetailsResponse flightDetailsResponse =new FlightDetailsResponse();
		List<FlightDetails> flightDetails=daoService.getFlightDetails(request);
		for(FlightDetails details : flightDetails) {
			long arrivalTime;
			long deptTime;
			try {
				arrivalTime = formatter.parse(details.getArriveTime()).getTime();
				deptTime= formatter.parse(details.getDepTime()).getTime();
				long diff=arrivalTime-deptTime;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				details.setDuration(String.valueOf(diffHours));	
				details.setDepartDate(request.getDepartDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}
		flightDetailsResponse.setFlightdetails(flightDetails);
		
		return flightDetailsResponse;
	}

	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request) {
		daoService.updateBookingDetail(request);
		BookingDetailsResponse response=daoService.getBookingDetails(request);
		long arrivalTime;
		long deptTime;
		try {
			arrivalTime = formatter.parse(response.getArrivalTime()).getTime();
			deptTime= formatter.parse(response.getDeptTime()).getTime();
			long diff=arrivalTime-deptTime;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			response.setDuration(String.valueOf(diffHours));				
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return response;
	}
}
