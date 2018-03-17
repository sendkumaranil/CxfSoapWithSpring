package com.cxfsoap.example.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder= {"faultDetails","sourceList","destinationList","flightdetails"})
public class FlightDetailsResponse {

	private List<FlightDetails> flightdetails;
	private ErrorResponse faultDetails;
	private SourceList sourceList;
	private DestinationList destinationList;
	
	public List<FlightDetails> getFlightdetails() {
		return flightdetails;
	}

	public void setFlightdetails(List<FlightDetails> flightdetails) {
		this.flightdetails = flightdetails;
	}

	public ErrorResponse getFaultDetails() {
		return faultDetails;
	}

	public void setFaultDetails(ErrorResponse faultDetails) {
		this.faultDetails = faultDetails;
	}

	public SourceList getSourceList() {
		return sourceList;
	}

	public void setSourceList(SourceList sourceList) {
		this.sourceList = sourceList;
	}

	public DestinationList getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(DestinationList destinationList) {
		this.destinationList = destinationList;
	}
}
