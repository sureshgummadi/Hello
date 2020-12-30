package com.example.demo.servimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Coupon;
import com.example.demo.repo.CouponRepository;
import com.example.demo.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService{
	@Autowired
	private CouponRepository repo;
	
	@Override
	@Transactional
	public Coupon saveCoupon(Coupon coupon) {
		return repo.save(coupon);
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getCouponById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getCouponByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCouponById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExpired(String code) {
		// TODO Auto-generated method stub
		return false;
	}

}
