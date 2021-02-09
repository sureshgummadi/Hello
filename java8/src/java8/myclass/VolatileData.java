package java8.myclass;

public class VolatileData   
{  
private volatile int counter = 0;   
public int getCounter()   
{  
return counter;  
}  
public void increaseCounter()   
{  
++counter;      //increases the value of counter by 1   
}
}
//  public static void main(String[] args) {
//	VolatileData v = new VolatileData();
//	v.increaseCounter();
//}
//}  


