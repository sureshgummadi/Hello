package com.app.in;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class DateApi {

	public static void main(String[] args) {
		LocalDate currTime = LocalDate.now();
        System.out.println("current date: "+currTime);
        
        LocalDate after10days = currTime.plus(Period.ofDays(10));       
        System.out.println("current date: "+after10days);
 
        LocalDate before3weeks = currTime.minus(Period.ofWeeks(3));       
        System.out.println("current date: "+before3weeks);
        
        Period betPer=Period.between(after10days, before3weeks);
        System.out.println(betPer.getDays());
        System.out.println(betPer.getMonths());
        
        System.out.println();
        
        LocalTime givenTime = LocalTime.of(2, 30, 15);
        System.out.println("time: "+givenTime);
        
        LocalTime updateTime= givenTime.plus(Duration.ofMinutes(20)).plus(Duration.ofSeconds(20));
        System.out.println(updateTime);
        
        Duration drt=Duration.between(givenTime, updateTime);
        System.out.println(drt.getSeconds());
        System.out.println(drt.toMinutes());
	}

}
