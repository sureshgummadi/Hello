package com.app.in;

public class StringReverse {
	public static void main(String[] args) {
		StringReverse rev = new StringReverse();
		System.out.println(rev.revrse("Hello hai okay"));
		System.out.println(rev.revesString("Hi ONe Tow"));
	}

	private String revesString(String str) {
		String reverse="";
		if(str.length() == 1) {
			return str;
		}else {
			reverse +=str.charAt(str.length()-1)+revesString(str.substring(0,str.length()-1));
			return reverse;
		}
	}
	public String revrse(String str) {
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		return rev;
	}
}
