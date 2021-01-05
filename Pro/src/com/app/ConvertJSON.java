package com.app;

public class ConvertJSON {

	static {
		System.out.println("static block");
	}
	//instance block
	{
		System.out.println("instance block");
	}
	static void disp() {
		System.out.println("static method");
	}
	void dis() {
		System.out.println("instance method");
	}
	public static void main(String[] args) {
		ConvertJSON c=new ConvertJSON();
		ConvertJSON.disp();
		c.dis();
	}

}
