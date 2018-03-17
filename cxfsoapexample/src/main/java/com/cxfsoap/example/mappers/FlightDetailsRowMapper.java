package com.cxfsoap.example.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.cxfsoap.example.model.FlightDetails;

public class FlightDetailsRowMapper implements RowMapper<FlightDetails> {
	
	@Override
	public FlightDetails mapRow(ResultSet rs, int rownum) throws SQLException {
		FlightDetails response=new FlightDetails();
		response.setFlightId(rs.getString("flightid"));
		response.setFlightName(rs.getString("flightname"));
		response.setSource(rs.getString("sources"));
		response.setDestination(rs.getString("destination"));		
		response.setDepTime(rs.getString("depttime"));
		response.setArriveTime(rs.getString("arrivaltime"));
		response.setTotalFare(rs.getBigDecimal("totalfare"));
		response.setTotalStop(rs.getInt("nostop"));
		String stopageAirport=rs.getString("stopageairport");
		if(stopageAirport!=null && !stopageAirport.isEmpty()) {
			List<String> stopageAirports=Arrays.asList(stopageAirport.split(","));
			response.setStopageAirports(stopageAirports);
		}		
		return response;
	}

}
