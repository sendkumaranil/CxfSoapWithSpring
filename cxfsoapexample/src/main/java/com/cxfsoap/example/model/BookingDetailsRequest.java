package com.cxfsoap.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookingDetailsRequest {

	private String flightId;
	private String departDate;
	private String noOfAdults;
	private String noOfChildren;
	private String travelClass;
	private String govtIdentityId;
	private String govtIdentityType;
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
	public String getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(String noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public String getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(String noOfChildren) {
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
}
