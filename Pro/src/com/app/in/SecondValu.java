package com.app.in;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondValu {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		int skip = 2;
		int size = list.size();
		
		int limit = size / skip + Math.min(size % skip, 1);

		List<Integer> result = Stream.iterate(list, l -> l.subList(skip, l.size()))
		    .limit(limit)
		    .map(l -> l.get(0))
		    .collect(Collectors.toList());

		System.out.println(result); 

	}

}
