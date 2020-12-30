package com.app.in;

public class SelectionSo {

	public static void main(String[] args) {
		int[] arr1= {4,98,6,46,86,566,65,697,7};
		int[] arr2=new int[arr1.length];
			arr2=doSelectionrt(arr1);
		int[] arr3=doSelectionrtA(arr1);
		for(int i:arr2) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.println("\n");
		for(int i:arr3) {
			System.out.print(i);
			System.out.print(", ");
		}
		
		
	}

	private static int[] doSelectionrt(int[] arr1) {
		int temp;
		for(int i=1;i<arr1.length;i++) {
			for(int j=i;j<arr1.length;j++) {
				if(arr1[j]<arr1[j-1]) {
					temp=arr1[j];
					arr1[j]=arr1[j-1];
					arr1[j-1]=temp;
				}
			}
		}
		return arr1;
	}

	private static int[] doSelectionrtA(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int index=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]>arr[index]) {
					index=j;
				}
				int sm=arr[index];
				arr[index]=arr[j];
				arr[j]=sm;
			}
		}
//		for(int i=0;i<arr.length;i++) {
//			if(i==arr.length-1) {
//				System.out.print(arr[i]);
//			}else {
//				System.out.print(arr[i]+",");
//			}
//		}
		return arr;
	}

}
