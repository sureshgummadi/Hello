package com.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountwordsiString {

	public static void main(String[] args) {
		String str = "He is very busy boy He is a good boy";
		int[] in= {15,26,45,15,36,5};
		int n=in.length;
		int[] a=new int[(n+1)/2];
		int[] bb=new int[n-a.length];
		String s[] = str.split(" ");
		HashMap<String, Integer> hm = new HashMap();
		for (int i = 0; i < s.length; i++) {
			if (hm.containsKey(s[i])) {
				hm.put(s[i], hm.get(s[i])+1);
			} else {
				hm.put(s[i], 1);
			}
		}
		System.out.print(hm);
	}
}
