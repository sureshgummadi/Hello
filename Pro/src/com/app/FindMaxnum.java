package com.app;

public class FindMaxnum {
	 public void maxNumbers(int[] nums){
	     int maxOne=0;
	     int maxTwo=0;
	     for(int n:nums){
		if(maxOne<n)
		{
		   maxTwo=maxOne;
		   maxOne=n;
		}else if(maxTwo>n){
		   maxTwo=n;
		}
	     }
		System.out.println(maxOne);
		System.out.println(maxTwo);
	    }
	public static void main(String[] args) {
		int num[]= {5,5,656,8,12,4556,65,4,48};
		FindMaxnum tm=new FindMaxnum();
		tm.maxNumbers(num);

	}

}
