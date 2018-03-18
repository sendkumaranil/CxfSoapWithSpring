package com.cxfsoap.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cxfsoap.example.dao.MoryaAirlinesDao;
import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.DestinationList;
import com.cxfsoap.example.model.ErrorResponse;
import com.cxfsoap.example.model.ErrorSeverity;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetailsResponse;
import com.cxfsoap.example.model.SourceList;

@Component
public class MoryaAirlinesValidator {
	
	@Autowired
	private MoryaAirlinesDao daoService;
			
	public FlightDetailsResponse validateSourceDestination(FlightDetailsRequest request) {
		FlightDetailsResponse validationResponse=new FlightDetailsResponse();
		
		ErrorResponse faultDetails=null;
		if(request.getSource().equalsIgnoreCase(request.getDestination())) {
			faultDetails=new ErrorResponse();
			faultDetails.setErrorCode("SAME_SOURCE_DESTINATION");
			faultDetails.setDescription("Invalid source or destination,source and destination can not be same!");
			faultDetails.setErrSeverity(ErrorSeverity.NORMAL);
			validationResponse.setFaultDetails(faultDetails);
			return validationResponse;
		}
		
		List<String> sources=daoService.fetchAllSources();
		List<String> destinations=daoService.fetchAllDestination();
		if(!sources.contains(request.getSource().toUpperCase())
				||!destinations.contains(request.getDestination().toUpperCase())) {
			faultDetails=new ErrorResponse();
			faultDetails.setErrorCode("INVALID_SOURCE_DESTINATION");
			faultDetails.setDescription("Invalid source or destination,please check valid source/destination list");
			faultDetails.setErrSeverity(ErrorSeverity.NORMAL);
			validationResponse.setFaultDetails(faultDetails);	
			SourceList sourceList=new SourceList();
			sourceList.setSources(sources);
			DestinationList destinationList=new DestinationList();
			destinationList.setDestinations(destinations);
			validationResponse.setSourceList(sourceList);
			validationResponse.setDestinationList(destinationList);
			return validationResponse;
		}else if(validateDate(request.getDepartDate())==Boolean.FALSE) {
			faultDetails=new ErrorResponse();
			faultDetails.setErrorCode("INVALID_DATE_FORMAT");
			faultDetails.setDescription("Invalid date format,valid date format [dd-MM-YYYY]");
			faultDetails.setErrSeverity(ErrorSeverity.NORMAL);
			validationResponse.setFaultDetails(faultDetails);	
			return validationResponse;
		}
		return null;
	}
	public static boolean validateDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    dateFormat.setLenient(false);
	    try {
	      dateFormat.parse(date.trim());
	    } catch (ParseException pe) {
	      return false;
	    }
	    return true;              
	}
	public BookingDetailsResponse validateBookingDetails(BookingDetailsRequest request) {
		BookingDetailsResponse validationResponse=new BookingDetailsResponse();
		ErrorResponse faultDetails=null;
		if(validateDate(request.getDepartDate())==Boolean.FALSE) {
			faultDetails=new ErrorResponse();
			faultDetails.setErrorCode("INVALID_DATE_FORMAT");
			faultDetails.setDescription("Invalid date format,valid date format [dd-MM-YYYY]");
			faultDetails.setErrSeverity(ErrorSeverity.NORMAL);
			validationResponse.setFault(faultDetails);	
			return validationResponse;
		}
		
		if(daoService.validateFlightId(request)==0) {
			faultDetails=new ErrorResponse();
			faultDetails.setErrorCode("INVALID_FLIGHTID");
			faultDetails.setDescription("Invalid flightid or seat not available");
			faultDetails.setErrSeverity(ErrorSeverity.NORMAL);
			validationResponse.setFault(faultDetails);
			return validationResponse;
		}
		return null;
	}
}
