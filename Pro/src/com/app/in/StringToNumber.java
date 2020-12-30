package com.app.in;

public class StringToNumber {

	public static void main(String[] args) {
		System.out.println("\"3256\" == "+convert_String_To_Number("3256"));
        System.out.println("\"76289\" == "+convert_String_To_Number("76289"));
        System.out.println("\"90087\" == "+convert_String_To_Number("90087"));
	}

	private static int convert_String_To_Number(String numstr) {
		char[] ch=numstr.toCharArray();
		int sum=0;
		int zeroAsscii=(int)'0';
		for(char c:ch) {
			int tempAsscii=(int)c;
			sum=(sum*10)+(tempAsscii-zeroAsscii);
		}
		return sum;
	}

}
