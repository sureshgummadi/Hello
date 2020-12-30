package com.app.sheduling;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmployeeReportGen {
	@Scheduled(fixedRate=5000)
	public void getTime() {
		System.out.println(new Date());
	}
	@Scheduled(cron="0 0/6 19 * * *")
	public void getTi() {
		System.out.println(new Date());
	}
}
