package com.cxfsoap.example.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightDetails {

	private String flightId;
	private String flightName;
	private String source;
	private String destination;
	private BigDecimal totalFare;
	private String depTime;
	private String arriveTime;
	private String duration;
	private String departDate;
	private Integer totalStop;
	private List<String> stopageAirports;
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
	public BigDecimal getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(BigDecimal totalFare) {
		this.totalFare = totalFare;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public Integer getTotalStop() {
		return totalStop;
	}
	public void setTotalStop(Integer totalStop) {
		this.totalStop = totalStop;
	}
	public List<String> getStopageAirports() {
		return stopageAirports;
	}
	public void setStopageAirports(List<String> stopageAirports) {
		this.stopageAirports = stopageAirports;
	}
	public ErrorResponse getFault() {
		return fault;
	}
	public void setFault(ErrorResponse fault) {
		this.fault = fault;
	}
	
}
