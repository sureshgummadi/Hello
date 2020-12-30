package com.app;

public class Example {

	public static void main(String[] args) {

		int arr[] = { 2, 5, 8, 6, 3, 1, 6, 7 };
		StringBuilder s = new StringBuilder();
		StringBuilder builder = new StringBuilder();
		int shiftElement =3 ;
		for (int i = 0; i < arr.length; i++) {
			if (i <= shiftElement - 1) {

				s.append(String.valueOf(arr[i]));
				if (i < shiftElement - 1)
					s.append(",");

			} else {
				builder.append(String.valueOf(arr[i]));

				if (i < arr.length)
					builder.append(",");
			}
		}
		builder.append(s.toString());
		System.out.println(builder);

	}
}
