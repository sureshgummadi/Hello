package com.app.model;

import java.util.stream.IntStream;

public class Prime {

	public static void main(String[] args) {
		int n = 10;
		isPrime(n);
	}
	public static boolean isPrime(int number) {
	    return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
	}
}
