package com.example.demo.model;
//table
public class Contact {
	private String address;
	private String phone;
	
	public Contact(String address, String phone) {
		super();
		this.address = address;
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
