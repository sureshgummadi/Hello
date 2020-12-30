package com.app.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDupl {

	public static void main(String[] args) {
		String s="aabbccdef";
	
		Set<Character> set=new LinkedHashSet<Character>();
		for(char c:s.toCharArray())
		{
		    set.add(Character.valueOf(c));
		}
		System.out.println(set);
	}

}
