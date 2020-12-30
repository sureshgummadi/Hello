package com.app;

import java.util.Scanner;

public class RightPiramid {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number :");
		int n=sc.nextInt();
		int i,j;
		for(i=0;i<n;i++) {
			System.out.print(" ");
		
		for(j=0;j<=i;j++) {
			System.out.print("* ");
		}
		System.out.println();
		}
	}
}
