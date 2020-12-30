package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Coupon;

public interface CouponService {
	public Coupon saveCoupon(Coupon coupon);

	public Coupon updateCoupon(Coupon coupon);

	public Coupon getCouponById(Integer id);

	public Coupon getCouponByCode(String code);

	public void deleteCouponById(Integer id);

	public List<Coupon> getAllCoupons();

	public boolean isExist(Integer id);

	public boolean isExpired(String code);
}
