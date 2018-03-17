package com.cxfsoap.example.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightDetailsResponse {

	private List<FlightDetails> flightdetails;

	public List<FlightDetails> getFlightdetails() {
		return flightdetails;
	}

	public void setFlightdetails(List<FlightDetails> flightdetails) {
		this.flightdetails = flightdetails;
	}
}
