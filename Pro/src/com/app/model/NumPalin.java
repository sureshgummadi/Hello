package com.app.model;

public class NumPalin {

	public static void main(String[] args) {
		int n=12321;
		ispalnum(n);

	}
	private static boolean ispalnum(int n) {
		int p=n;
		int rv=0;
		while(p!=0) {
			int re=p%10;
			rv=rv*10+re;
			p=p/10;
		}
		if(n == rv) {
			System.out.println("is");
			return true;
		}
		System.out.println("not");
		return false;
	}
}
