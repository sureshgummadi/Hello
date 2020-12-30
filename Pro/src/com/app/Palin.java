package com.app;

import java.util.Scanner;

public class Palin {

	public static void main(String[] args) {
		String rev="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter A String");
		String s=sc.next();
		for(int i=s.length()-1;i>=0;i--) {
			rev=rev+s.charAt(i);
		}
		if(s.equals(rev))
		{
			System.out.println("is Plindrome");
		}else {
			System.out.println("is Not Palindrome");
		}
	}

}
