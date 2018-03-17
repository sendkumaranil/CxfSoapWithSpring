package com.cxfsoap.example.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DestinationList {

	private List<String> destinations;

	public List<String> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}
}
