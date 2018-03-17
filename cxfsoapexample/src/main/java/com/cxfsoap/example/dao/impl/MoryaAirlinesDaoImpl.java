package com.cxfsoap.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cxfsoap.example.dao.MoryaAirlinesDao;
import com.cxfsoap.example.mappers.BookingDetailsRowMapper;
import com.cxfsoap.example.mappers.FlightDetailsRowMapper;
import com.cxfsoap.example.model.BookingDetailsRequest;
import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.FlightDetailsRequest;
import com.cxfsoap.example.model.FlightDetails;

@Repository
public class MoryaAirlinesDaoImpl  implements MoryaAirlinesDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<FlightDetails> getFlightDetails(FlightDetailsRequest request) {
		String fetchFlightDetailsSql="select * from moryaflights.flightsdetails where sources=? and destination=? and totalseats > 0";
		Object[] params=new Object[] {
			request.getSource().toUpperCase(),
			request.getDestination().toUpperCase()
		};
		return jdbcTemplate.query(fetchFlightDetailsSql, params, new FlightDetailsRowMapper());
	}
	@Transactional(rollbackFor=Exception.class)
	public void updateBookingDetail(BookingDetailsRequest request) {
		String insertBookingDetails="insert into moryaflights.bookingdetails(bookingdate,flightid,traveldate,boardingairport,arrivalairport," + 
				"passengername,govtid,govtidtype,travelclass,adults,children,description)" + 
				"values(sysdate(),?,?,?,?,?,?,?,?,?,?,?)";
		
		Object[] params=new Object[] {
				request.getFlightId(),
				request.getDepartDate(),
				"Indira Gandhi International Airport-Terminal-I",
				"Kempu Gowda Internation Airport-Terminal-II ",
				request.getPassengerName(),
				request.getGovtIdentityId(),
				request.getGovtIdentityType(),
				request.getTravelClass(),
				request.getNoOfAdults(),
				request.getNoOfChildren(),
				"Please come 2 hours before boarding time for security check and boarding procedures,Thank You!"
		};
		jdbcTemplate.update(insertBookingDetails, params);
		
		String getTotalSeatsSql="select totalseats from moryaflights.flightsdetails where flightid=?";
		Object[] params2=new Object[] {
				request.getFlightId()
		};
		int totalSeats=jdbcTemplate.queryForObject(getTotalSeatsSql, params2, Integer.class);
		
		String updateTotalSeatSql="update moryaflights.flightsdetails set totalseats=? where flightid=?";
		int remainingSeats=totalSeats-(request.getNoOfAdults()+request.getNoOfChildren());		
		jdbcTemplate.update(updateTotalSeatSql, remainingSeats,request.getFlightId());		
	}
	
	public BookingDetailsResponse getBookingDetails(BookingDetailsRequest request) {
		String fetchBookingDetailSql="select flight.flightid,flight.flightname,flight.depttime,flight.arrivaltime," + 
				"flight.nostop,flight.stopageairport,flight.totalfare,booking.bookingdate,booking.adults,booking.children,booking.govtid,booking.govtidtype,booking.boardingairport,booking.arrivalairport," + 
				"booking.passengername,booking.travelclass,booking.traveldate,booking.description from moryaflights.flightsdetails flight inner join moryaflights.bookingdetails booking " + 
				"on flight.flightid=booking.flightid where booking.govtid=? and booking.flightid=?";
		Object[] params=new Object[] {
			request.getGovtIdentityId(),
			request.getFlightId()
		};
		
		return jdbcTemplate.queryForObject(fetchBookingDetailSql, params, new BookingDetailsRowMapper());
	}
}
