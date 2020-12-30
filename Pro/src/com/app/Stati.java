package com.app;

public class Stati {
	static int i = 100;
	  static String s = "Beginnersbook";
	  //Static method
	  static 
	  {
	     System.out.println("i:"+i);
	     System.out.println("i:"+s);
	  }

	  //non-static method
	  void funcn()
	  {
	      //Static method called in non-static method
		  System.out.println("hello");
	      display();
	  }
	  //static method

		
		  public static void main(String args[])
		  {
			  Stati obj = new Stati();
			  //You need to have object to call this non-static method
			  obj.funcn();
			  
		      //Static method called in another static method
		      display();
		   }

}
