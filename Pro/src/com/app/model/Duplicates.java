package com.app.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Duplicates {

	public static void main(String[] args) {
		List<String> arrList = Arrays.asList("subbu","subbu","sari","sari","ram");
	    arrList.stream().distinct().forEach(System.out::println);

	}

}
