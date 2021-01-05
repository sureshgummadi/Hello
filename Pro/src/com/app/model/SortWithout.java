package com.app.model;

public class SortWithout {

	public static void main(String[] args) {
		int[] arr=new int[] {1,58,2,15,34,36,1112,1,56,33,554};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int temp=0;
				if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			System.out.println(arr[i]);
		}

	}

}
