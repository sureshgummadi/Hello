package com.example.demoexception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Configuration;



@Configuration
public class ApiError {
	private String errorCode;
	private String errorDesc;
	private Date errorDate;
	private List<String> validationErrors =new ArrayList<>();
		
	public ApiError() {
		super();
	}
	public ApiError(String errorCode, String errorDesc, Date errorDate, List<String> validationErrors) {
		super();
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
		this.errorDate = errorDate;
		this.validationErrors = validationErrors;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public Date getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}
	public List<String> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	
}
