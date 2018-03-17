package com.cxfsoap.example.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder= {"errorCode","errSeverity","description"})
public class ErrorResponse {

	private String errorCode;
	private String description;
	private ErrorSeverity errSeverity;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ErrorSeverity getErrSeverity() {
		return errSeverity;
	}
	public void setErrSeverity(ErrorSeverity errSeverity) {
		this.errSeverity = errSeverity;
	}
}
