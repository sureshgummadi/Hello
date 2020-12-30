package com.app.model;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadString {
	public static String readFileAsString(String fileName)throws Exception 
	  { 
	    String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(fileName))); 
	    return data; 
	  } 
	public static void main(String[] args) throws Exception {
		String data=readFileAsString("D:\\fetch.txt");
		System.out.println(data);
	}

}
