package com.cxfsoap.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightDetailsRequest {

	private String source;
	private String destination;
	private String departDate;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
}
