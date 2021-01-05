package com.app.model;

public class Sorting {

	public static void main(String[] args) {
		String[] str= {"subbu","mani","prany","raghu"};
		int n=str.length;
		stringSorting(str,n);
		for(int i=0;i<n;i++) {
			System.out.println("String "+(i+1)+"is  "+str[i]);
		}

	}

	private static void stringSorting(String[] str, int n) {
		String temp;
		for(int j=0;j<n-1;j++) {
			for(int i=j+1;i<n;i++) {
				if(str[j].compareTo(str[i])>0) {
					temp=str[j];
					str[j]=str[i];
					str[i]=temp;
				}
			}
			
		}
		
	}

}
