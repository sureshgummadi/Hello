package com.app;

import java.util.Scanner;

public class PrimeRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(" Please Enter first Number : ");
		int first = sc.nextInt();

		System.out.print(" Please Enter second Number : ");
		int second = sc.nextInt();

		for (int i = first; i < second; i++) {
			int count = 0;
			for (int j = 2; j < i; j++) {

				if (i % j == 0) {
					count++;
				}
			}
			if(count ==0) {
				System.out.print(" "+i);
			}
			

		}

	}
}
