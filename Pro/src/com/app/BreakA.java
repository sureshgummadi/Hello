package com.app;

public class BreakA extends Thread implements Runnable{
	 public void run() 
	    { 
	        System.out.printf("ASD "); 
	    } 
	public static void main(String[] args) {
		
		BreakA obj = new BreakA(); 
        
        obj.run(); 
       System.out.println("run");
        obj.start(); 
        System.out.println("start");
        
		for(int i = 0; i<=1; i++) {
			System.out.println("Hello");
			break;
			
		}
		System.out.println(obj.fun()); 
	}
	 int fun() { 
	        return 20; 
	    }
}
