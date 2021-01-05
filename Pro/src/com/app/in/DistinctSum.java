package com.app.in;

import java.util.Arrays;

public class DistinctSum {

	public static void main(String[] args) {
		Integer[] numbers= {12,10,9,45,10,10,45,10};
		for(int i=0;i<numbers.length;i++) {
			boolean dis=true;
			for(int j=0;j<i;j++) {
				if(numbers[i]==numbers[j]) {
				dis=false;
				break;
				}
			}
			if(dis) {
				System.out.println(numbers[i]+" ");
			}	
		}	
		System.out.println();
		Integer[] intnumbers = {1,2,23,43,23,56,7,9,11,12,12,67,54,23,56,54,43,2,1,19};
		int sumofints = Arrays.stream(intnumbers)
		               .distinct()
		               .mapToInt(Integer::intValue)
		               .sum();
		System.out.println(sumofints);
	}
	
	
}
