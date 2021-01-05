package com.app.in;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FequentNum {

	public static void main(String[] args) {
		  int[] a = new int[]{ 1,3, 2, 1, 4, 5,1};
	        System.out.println(getMostPopularElement(a));  
	        
	        
	        Map<Integer, Long> count = Arrays.stream(a)
	    	        .boxed()
	    	        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

	    	    int max = count.entrySet().stream()
	    	        .max((first, second) -> {
	    	            return (int) (first.getValue() - second.getValue());
	    	        })
	    	        .get().getKey();

	    	    System.out.println(max);
	    }

	    private static int getMostPopularElement(int[] a) {             
	        int maxElementIndex = getArrayMaximumElementIndex(a); 
	        int[] b = new int[a[maxElementIndex] + 1];

	        for (int i = 0; i < a.length; i++) {
	            ++b[a[i]];
	        }

	        return getArrayMaximumElementIndex(b);
	    }

	    private static int getArrayMaximumElementIndex(int[] a) {
	        int maxElementIndex = 0;

	        for (int i = 1; i < a.length; i++) {
	            if (a[i] >= a[maxElementIndex]) {
	                maxElementIndex = i;
	            }
	        }
	        return maxElementIndex;
	    } 
}
