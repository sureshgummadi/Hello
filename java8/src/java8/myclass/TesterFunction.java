package java8.myclass;
import java.util.function.*;
 class TesterFunction {
	
	public static void main(String[] args) {
		Function<Integer,Integer> f = i->i*i;
		System.out.println("The Square of 4:"+f.apply(4));
		Predicate<Integer> p = i->i%2==0;
		System.out.println(p.test(4));
	}
}
