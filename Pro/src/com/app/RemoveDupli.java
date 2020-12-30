package com.app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class RemoveDupli {

	public static void main(String[] args) {
		
		  String s = "har ikr ish na ram raghu raghu ram"; 
		  String s2 = ""; 
		  for (int i = 0; i < s.length(); i++) { 
			  Boolean found = false; 
			  for (int j = 0; j < s2.length(); j++) { 
				  if (s.charAt(i) == s2.charAt(j)) { found = true; break;
			  }
		  //don't need to iterate further } } 
				  if (found == false)
				  { 
					  s2 = s2.concat(String.valueOf(s.charAt(i))); 
					} 
			} System.out.println(s2);
				  }
		 

		String a[] = { "man", "person", "hello","hello","person" };
        Arrays.stream(a).map(m -> m.toUpperCase()).forEach(System.out::println);
        System.out.println();
        Stream.of(a).map(m->m.toUpperCase()).forEach(System.out::println);
       
		/*
		 * List<String> list = Arrays.asList("man","person","hello"); list.stream()
		 * .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
		 * .forEachOrdered(n -> System.out.println(n)); System.out.println(); String
		 * string = new String("abc"); String b = "abc";
		 * 
		 * String c = new String("abc");
		 */
//		System.out.println(string == b);
//		System.out.println(string.equals(b));
//		System.out.println(string == c);
		
		/*
		 * StringBuilder stringBuilder = new StringBuilder("abc"); StringBuilder
		 * stringBuilder1 = new StringBuilder("abc"); System.out.println(stringBuilder
		 * == stringBuilder1); System.out.println(stringBuilder.equals(
		 * stringBuilder1));
		 */
	}

}
