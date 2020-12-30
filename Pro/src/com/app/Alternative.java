package com.app;

import java.time.LocalDateTime;

public class Alternative {

	public static void main(String[] args) {
		LocalDateTime ldtObj = LocalDateTime.now();
        System.out.println("Current date & time without zone: "+ldtObj);
		
		String str = "Welcome hdsfg jhsgdvj";
		//char[] strChars = str.toCharArray();
		for(int i = 1; i < str.length(); i++) { 
			if(i%2!=0) {
		    System.out.print(str.charAt(i));
			}
		}
	}
}
