package com.app;

public class BinaryOnNot {
	public static void main(String[] args) {
		 BinaryOnNot bon=new BinaryOnNot();
		 System.out.println("It Is Binary or Not -->"+bon.isBinaryOrNot(100011000));
		 System.out.println("It Is Binary or Not -->"+bon.isBinaryOrNot(1002301000));
	}

	private boolean isBinaryOrNot(int binary) {
		boolean status=true;
		while(true) {
			if(binary==0) {
				break;
			}else {
				int temp=binary%10;
				if(temp>1) {
					status=false;
					break;
				}
				binary=binary/10;
			}
		}
	return status;
	}
}
