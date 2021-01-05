package com.app.model;

public class Fibonacci {

	public static void main(String[] args) {
		int n=15;
		int a=0;
		int b=1;
		int c=a+b;
		while(c<=n) {
			System.out.print(" "+c);
			c=a+b;
			a=b;
			b=c;
		}

	}

}
