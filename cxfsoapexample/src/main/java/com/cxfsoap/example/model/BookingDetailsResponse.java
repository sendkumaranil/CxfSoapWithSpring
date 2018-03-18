package com.cxfsoap.example.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder= {"fault","bookingDate","flightId","flightName","deptTime",
		"arrivalTime","duration","totalFare","travelClass","departDate","boardingAirport",
		"arrivalAirport","stops","stopageAirports","noOfAdults","noOfChildren","govtIdentityId",
		"govtIdentityType","passengerList","description"})
public class BookingDetailsResponse {

	private String bookingDate;
	private String flightId;
	private String flightName;
	private String deptTime;	
	private String arrivalTime;
	private String duration;
	private BigDecimal totalFare;
	private String travelClass;
	private String departDate;
	private String boardingAirport;
	private String arrivalAirport;
	private Integer stops;
	private List<String> stopageAirports;
	private Integer noOfAdults;
	private Integer noOfChildren;
	private String govtIdentityId;
	private String govtIdentityType;
	private String description;
	private PassengerList passengerList;
	private ErrorResponse fault;
	
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getDeptTime() {
		return deptTime;
	}
	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public BigDecimal getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(BigDecimal totalFare) {
		this.totalFare = totalFare;
	}
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public String getBoardingAirport() {
		return boardingAirport;
	}
	public void setBoardingAirport(String boardingAirport) {
		this.boardingAirport = boardingAirport;
	}
	public Integer getStops() {
		return stops;
	}
	public void setStops(Integer stops) {
		this.stops = stops;
	}
	public List<String> getStopageAirports() {
		return stopageAirports;
	}
	public void setStopageAirports(List<String> stopageAirports) {
		this.stopageAirports = stopageAirports;
	}
	public Integer getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(Integer noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public Integer getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ErrorResponse getFault() {
		return fault;
	}
	public void setFault(ErrorResponse fault) {
		this.fault = fault;
	}
	
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public PassengerList getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(PassengerList passengerList) {
		this.passengerList = passengerList;
	}
}
