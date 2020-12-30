package com.app;

public class SiftNumberAndEvenNumber {

	public static void main(String[] args) {

		int arr[] = {1,2,3,4,5};
		int arr1[] = new int[arr.length];
		int shiftAmount=3;
		
		for(int i = 0; i < arr.length; i++){
			int newLocation = (i + (arr.length - shiftAmount)) % arr.length;
			arr1[newLocation] = arr[i];
			
		}
		for(int i=0;i<arr1.length;i++) {
			if(i==arr1.length-1) {
				System.out.print(arr1[i]);
			}else {
				System.out.print(arr1[i]+",");
			}
		}
		System.out.println();
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]%2==0) {
				System.out.print(arr1[i]+" ");
			}
		}
	}
}
