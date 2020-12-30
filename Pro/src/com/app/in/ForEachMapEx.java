package com.app.in;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ForEachMapEx {

	public static void main(String[] args) {
		
		
		 Instant currTimeStamp = Instant.now();
	        System.out.println("current timestamp: "+currTimeStamp);
		
	        System.out.println("current time in milli seconds: "+currTimeStamp.toEpochMilli());
	        
	        
		 Map<String, String> countryMap = new HashMap<>();
	        countryMap.put("India", "Delhi");
	        countryMap.put("USA", "Washington, D.C.");
	        countryMap.put("Japan", "Tokyo");
	        countryMap.put("Canada", "Ottawa");
	        ForEachMapEx.itrateMap(countryMap);
	        ForEachMapEx.itrateMapForEach(countryMap);
	        
	        
	        
	        List<String> countryList = new ArrayList<>();
	        countryList.add("India");
	        countryList.add("USA");
	        countryList.add("Japan");
	        countryList.add("Canada");
	        System.out.println();
	        ForEachMapEx.itrateList(countryList);
	        System.out.println();
	        ForEachMapEx.itrateListForEach(countryList);
	}

	private static void itrateListForEach(List<String> countryList) {
		
		countryList.forEach(country->System.out.println(countryList));
	}

	private static void itrateList(List<String> countryList) {
		for(String country:countryList)
		{
			System.out.println(country);
		}
	}

	private static void itrateMapForEach(Map<String, String> countryMap) {
		System.out.println("--------------------");
		countryMap.forEach((k,v)->System.out.println(k +" "+ v));
		
	}

	private static void itrateMap(Map<String, String> countryMap) {
		
		for(Entry<String, String> entry:countryMap.entrySet()) {
			System.out.println(entry.getKey() +"   "+ entry.getValue());
		}
	}

}
