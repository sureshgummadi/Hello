package com.app.in;

public class BubbleS {

	public static void main(String[] args) {
		int[] arr= {4,98,6,46,86,566,65,697,7};
		bubble_sort(arr);
	}

	private static void bubble_sort(int[] arr) {
		int n=arr.length;
		int k;
		for(int m=n;m>=0;m--) {
			for(int i=0;i<n-1;i++) {
				k=i+1;
				if(arr[i]>arr[k]) {
					swapnumbers(i,k,arr);
				}
			}
		}
		printnumbers(arr);
	}

	private static void printnumbers(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

	private static void swapnumbers(int i, int k, int[] arr) {
		int temp=arr[i];
		arr[i]=arr[k];
		arr[k]=temp;
		
	}
}
