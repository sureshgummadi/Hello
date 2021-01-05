package com.app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class TestAge {

	public static void main(String[] args) {
		Map<String,Persion> map1=new HashMap<>();
		map1.put("1", new Persion(1,"ram",20));
		map1.put("2", new Persion(2,"nag",14));
		map1.put("3", new Persion(3,"subbu",16));
		map1.put("4", new Persion(4,"pran",18));
		
		List<Persion> collect = map1.values().stream().filter(p -> p.getAge() >=16).collect(Collectors.toList());
		long count=collect.stream().filter(e->e.getAge()>=16).count();
		
		Optional<Persion> p=collect.stream().filter(n->n.getName().equalsIgnoreCase("subbu")).findAny();
		if(p.isPresent()) 
			System.out.println(p.get());
		
		OptionalInt in=collect.stream().mapToInt(Persion::getAge).max();
		if(in.isPresent())
			System.out.println("Max age  Present "+in.getAsInt());
		
		
		List<String> lisemp=collect.stream().map(Persion::getName).collect(Collectors.toList());
		String name=String.join(",",lisemp);
		System.out.println("Persion Names with camm separated :: "+name);
		
		System.out.println("Find Name "+p);
		System.out.println(collect);
		System.out.println("Number of Persions  "+count);
	}

}
