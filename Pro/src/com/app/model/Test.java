package com.app.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		 List < Employee > employees = new ArrayList < Employee > ();
	        employees.add(new Employee(10, "Ramesh", 30, 400000));
	        employees.add(new Employee(20, "John", 29, 350000));
	        employees.add(new Employee(30, "Tom", 30, 450000));
	        employees.add(new Employee(40, "Pramod", 29, 500000));
	        
	        List<Employee> listEmployee=employees.stream().sorted((o1,o2)->(int)(o1.getSalary()-o2.getSalary())).collect(Collectors.toList());
	        System.out.println(listEmployee);
	        
	        List<Employee> listEmployee1=employees.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).collect(Collectors.toList());
	        System.out.println(listEmployee1);


	}

}
