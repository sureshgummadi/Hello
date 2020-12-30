package com.app;

public class ReverseNum {

	public static void main(String[] args) {
		ReverseNum rev=new ReverseNum();
		System.out.println(rev.reverseNumbers(15864763));
	}

	public int reverseNumbers(int number) {
		int reverse=0;
		while(number != 0) {
			reverse=(reverse*10)+(number%10);
			number=number/10;
		}
		return reverse;
	}
}
