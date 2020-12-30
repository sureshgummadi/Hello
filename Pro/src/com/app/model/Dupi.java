package com.app.model;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class Dupi {

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{100,24,13,44,114,200,40,112};
		Integer[] in=new Integer[] {1,5,7,69,69,5,6,3,2};
		List<Integer> li=Arrays.asList(in);
		
		li=Arrays.asList(in);
		OptionalDouble op=li.stream().mapToInt(n->n*n).filter(n->n>1000).average();
		if(op.isPresent())
			System.out.println(op.getAsDouble());
		
		
		Set<Integer> collect = li.stream().distinct().collect(Collectors.toSet());
		//collect.forEach((i)->System.out.print(" "+i));
		System.out.println(collect);
	}

}
