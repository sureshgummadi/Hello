package com.app.in;

public class Prct1 {

	public static void main(String[] args) {
		int[] a=new int[]{1,3,2,1,4,5,1};
		System.out.println(getMostPopulerIndex(a));
	}

	private static int getMostPopulerIndex(int[] a) {
		int maxindex=getArrayMaxIndex(a);
		int[] b=new int[a[maxindex]+1];
		for(int i=0;i<a.length;i++) {
			++b[a[i]];
		}
		return getArrayMaxIndex(b);
	}

	private static int getArrayMaxIndex(int[] a) {
		int m=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>a[m]) {
				m=i;
			}
		}
		return m;
	}

}
