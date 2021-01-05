package com.app.model;

public class SortImpl {

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 8, 7, 4, 32, 78, 54, 9, 12, 10};

	    for (int i = 0; i < arr.length; i++) {
	        for (int j = i + 1; j < arr.length; j++) {
	            int tmp = 0;
	            if (arr[i] > arr[j]) {
	                tmp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = tmp;
	            }
	        }
	        if(i==arr.length-1) {
				System.out.print(arr[i]);
			}else {
				System.out.print(arr[i]+",");
			}
	    }
	}
}
