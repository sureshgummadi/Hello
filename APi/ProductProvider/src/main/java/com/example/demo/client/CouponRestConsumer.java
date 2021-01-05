package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Coupon;

@FeignClient("COUPON-APP")
public interface CouponRestConsumer {
	@GetMapping("/rest/coupon/getByCode/{code}")
	public Coupon getCouponByCode(@PathVariable String code);

	@GetMapping("/rest/coupon/check/{code}")
	public String checkExpiredOrNot(@PathVariable String code);
}
