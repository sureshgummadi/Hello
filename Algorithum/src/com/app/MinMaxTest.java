package com.app;

import java.util.Scanner;

public class MinMaxTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number");
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Numbers "+(i+1)+"are ");
			arr[i]=sc.nextInt();
		}
		MinMax mm=new MinMax();
		System.out.println("Maximum Number is "+mm.getMax(arr));
		//System.out.println("Minimum Number is "+mm.getMin(arr));
	}
}
