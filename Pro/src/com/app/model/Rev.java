package com.app.model;

public class Rev {

	public static void main(String[] args) {
		String str="as23bs34534nmn45n435n";
		swhoNumericandString(str);

	}

	private static void swhoNumericandString(String str) {
		String number="";
		String latter="";
		
		for(int i=0;i<str.length();i++) {
			char a=str.charAt(i);
			if(Character.isDigit(a)) {
				number+=a;
			}else {
				latter+=a;
			}
		}
		System.out.println(latter);
		System.out.println(number);
	}

}
