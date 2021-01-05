package com.example.demo.response;

public class Response {
	private String message;
	private String status;
	
	public Response(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}

	public Response() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
