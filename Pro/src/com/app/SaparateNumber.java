package com.app;

import java.util.Scanner;

public class SaparateNumber {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	        int num,digit;
	        System.out.println("Enter the Number:");
	        num = scan.nextInt();
	        while(num>0){
	            digit = num%10;
	            num = num/10;
	            System.out.print(digit);
	            if(num>0){     //it is used for remove last comma
	                System.out.print(",");
	            }
	        }
	}

}
