package com.app.in;

public class Multiple {

	public static void main(String[] args) {
		int output = 0;
		int range = 11;
		for (int i=1;i < range; i++) {
		if (i % 3 == 0 || i % 5 == 0 ) {
		output = output + i;
		}
		}
		System.out.println(output);
	}
}
