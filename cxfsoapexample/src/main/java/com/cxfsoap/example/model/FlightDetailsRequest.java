package com.cxfsoap.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightDetailsRequest {

	private String source;
	private String destination;
	private String departTime;
	
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
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
}
