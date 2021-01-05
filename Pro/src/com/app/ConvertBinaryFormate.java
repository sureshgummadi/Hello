package com.app;

public class ConvertBinaryFormate {

	public static void main(String[] args) {
		ConvertBinaryFormate con=new ConvertBinaryFormate();
		con.convertingBinary(26);
		System.out.println("\n");
		System.out.print(con.reverseNumber(345345345));
		System.out.println();
		System.out.print(con.revString("Hi Hello humm"));
		System.out.println();
		
		System.out.println("Perfect Number "+con.isPerfactNumber(6));
		
		System.out.println();
		con.allPerfectNumbers();
	}

	private int reverseNumber(int i) {
		int rev=0;
		while(i!=0) {
			rev=(rev*10)+(i%10);
			i =i/10;
		}
		return rev;
	}

	public String revString(String str) {
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		return rev;
	}
	
	private void convertingBinary(int number) {
		int binary[]=new int[number];
		int index=0;
		while(number>0) {
			binary[index++]=number%2;
			number = number/2;
		}
		for(int i=index-1;i>=0;i--) {
			System.out.print(binary[i]);
		}
	}
	
	public boolean isPerfactNumber(int number) {
		int temp=0;
		for(int i=1;i<=number/2;i++) {
			if(number%i==0) {
				temp +=i;
			}
		}
		if(temp==number) {
			System.out.println("is perfact");
			return true;
		}else {
			System.out.println("not perfact");
			return false;
		}
	}
	
	public void allPerfectNumbers() {
		int sum;
		for(int i=1;i<100;i++) {
			sum=0;
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					sum =+j;
				}
			}
			if(sum==i) {
				System.out.println(sum);
			}
		}	
	}
}
