package com.app;

import java.util.Scanner;

public class All1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(" Please Enter any Number : ");
		int number = sc.nextInt();
		for (int i = 1; i <= number; i++) {
			for (int j = 0; j <= 3; j++) {
				System.out.print(i + "  ");
				if (j != 3) {
					i++;
				}
				/*
				 * if(i>num) { break; }
				 */
			}
			System.out.println();
		}
		// NaturalNumbers(number);
	}
	/*
	 * public static void NaturalNumbers(int num) { for(int i = 1; i <= num; i++) {
	 * for(int j=0;j<=3;j++) { System.out.print(i +"  "); if(j!=3) { i++; }
	 * 
	 * if(i>num) { break; }
	 * 
	 * } System.out.println(); } }
	 */
}
