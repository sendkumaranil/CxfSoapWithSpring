package com.cxfsoap.example.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SourceList {

	private List<String> sources;

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}
}
