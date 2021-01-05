package com.app.model;

import java.util.Random;

public class CountChar {

	public static void main(String[] args) {
		/*
		 * Random r=new Random();
		 * r.ints().limit(15).sorted().forEach(System.out::Println);
		 */
		
		String str="dfjshdbf";
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!=' ') {
				count++;
			}
		}
		System.out.println("Count number "+count);
	}

}
