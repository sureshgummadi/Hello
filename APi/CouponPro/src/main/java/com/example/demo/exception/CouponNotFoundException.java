package com.example.demo.exception;

public class CouponNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2627003438670611967L;

	public CouponNotFoundException(String s) {
		super(s);
	}
}
