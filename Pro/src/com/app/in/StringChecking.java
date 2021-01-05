package com.app.in;

import java.util.ArrayList;
import java.util.List;

public class StringChecking {
	private static final String VALUE = "bookstore"; 
 	public static List<String> getSubStrings(String inputString){
		List<String> subStringsList=new ArrayList<>();
		for(int i=0;i<inputString.length();i++)
		{ 
		  for(int j=i+1;j<=inputString.length();j++)
		   {
			subStringsList.add(inputString.substring(i,j));
		   }
                }
 	return subStringsList; 
	}
	public static void main(String[] args) {
		List<String> subStringsList=getSubStrings(VALUE);
 		subStringsList.forEach(n->{
		String outPutValue=getStringBasedOnPrefix(n);
		System.out.println(outPutValue!=null && !outPutValue.isEmpty() ? outPutValue: "");
		} );
	}
	public static String getStringBasedOnPrefix(String value){
		char firstChar=value.charAt(0);
		char lastChar=value.charAt(value.length());
		 if(firstChar == lastChar){
			 return value;     
			} else{
				return null;      
			}      
	}
}
