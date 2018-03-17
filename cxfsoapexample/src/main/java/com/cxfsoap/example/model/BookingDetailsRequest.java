package com.cxfsoap.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookingDetailsRequest {

	private String flightId;
	private String departDate;
	private int noOfAdults;
	private int noOfChildren;
	private String travelClass;
	private String govtIdentityId;
	private String govtIdentityType;
	private String passengerName;
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	public String getGovtIdentityId() {
		return govtIdentityId;
	}
	public void setGovtIdentityId(String govtIdentityId) {
		this.govtIdentityId = govtIdentityId;
	}
	public String getGovtIdentityType() {
		return govtIdentityType;
	}
	public void setGovtIdentityType(String govtIdentityType) {
		this.govtIdentityType = govtIdentityType;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
}
