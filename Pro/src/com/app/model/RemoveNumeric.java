package com.app.model;

public class RemoveNumeric {

	public static void main(String[] args) {
		String input = "1a2b3c4defgh567jkl";
        separateDigitsAndAlphabets(input);

	}
	public static void separateDigitsAndAlphabets(String str) {
        String number = "";
        String letter = "";
        for (int i = 0; i < str.length(); i++) {
               char a = str.charAt(i);
               if (Character.isDigit(a)) {
                     number = number + a;

               } else {
                     letter = letter + a;

               }
        }
        System.out.println("Alphates in string:"+letter);
        System.out.println("Numbers in String:"+number);

 }
}
