package com.app;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("shd",1);
		map.put("sfg",2);
		map.put("sfdgfd",3);
		map.put("vxfdgsfd",4);
		map.put("xcv",5);
		map.put("ty",6);
		map.put("bvn",7);	
		map.entrySet().stream().forEach(e->System.out.println("Key :"+e.getKey() +"--> value :"+e.getValue()));
	}
}
