package com.cxfsoap.example.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.PassengerList;

public class BookingDetailsRowMapper implements RowMapper<BookingDetailsResponse> {

	@Override
	public BookingDetailsResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookingDetailsResponse response=new BookingDetailsResponse();
		response.setBookingDate(rs.getString("bookingdate"));
		response.setFlightId(rs.getString("flightid"));
		response.setFlightName(rs.getString("flightname"));
		response.setDeptTime(rs.getString("depttime"));
		response.setArrivalTime(rs.getString("arrivaltime"));
		response.setBoardingAirport(rs.getString("boardingairport"));
		response.setArrivalAirport(rs.getString("arrivalairport"));
		response.setTotalFare(rs.getBigDecimal("totalfare"));
		response.setTravelClass(rs.getString("travelclass"));
		response.setStops(rs.getInt("nostop"));
		String stopageAirport=rs.getString("stopageairport");
		if(stopageAirport!=null && !stopageAirport.isEmpty()) {
			List<String> stopageAirports=Arrays.asList(stopageAirport.split(","));
			response.setStopageAirports(stopageAirports);
		}			
		String passengers=rs.getString("passengername");
		List<String> names=Arrays.asList(passengers.split(","));
		PassengerList passengerList=new PassengerList();
		passengerList.setName(names);
		response.setPassengerList(passengerList);
		response.setGovtIdentityId(rs.getString("govtid"));
		response.setGovtIdentityType(rs.getString("govtidtype"));
		response.setNoOfAdults(rs.getInt("adults"));
		response.setNoOfChildren(rs.getInt("children"));
		response.setDescription(rs.getString("description"));
		return response;
	}

}
