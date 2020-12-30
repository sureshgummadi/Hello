package com.example.demo.validate;

public class Validations {
		public static boolean isNameValid(String str) {
		 return str.matches("/^[A-Za-z]+/");
	    }

	    public static boolean isMobileValid(String str) {
	        return (str.matches("[6-9]{1}[0-9]{9}"));
	    }

	    public static boolean isEmailValid(String str) {
	        return (str.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"));
	    }

	    public static boolean isPassWordValid(String str) {
	        return (str.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$"));

	    }
}
