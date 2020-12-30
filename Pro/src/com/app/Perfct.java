package com.app;

import java.util.Scanner;

public class Perfct {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int num=sc.nextInt();
		int sum=0;
		for(int i=0;i<num;i++) {
			sum=0;
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					sum=sum+j;
				}
			}
			if(sum==i && sum!=0) {
				System.out.print(i+"\t");
			}
		}

	}

}
