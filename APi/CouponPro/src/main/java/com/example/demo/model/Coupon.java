package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="coupon_micro")
public class Coupon implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="coupon_id")
	private Integer couponId;
	@Column(name="coupon_code", length=25)
	private String couponCode;
	@Column(name="coupon_discount")
	private Double couponDisc;
	@Column(name="coupon_expiry")
	@Temporal(TemporalType.DATE)
	private Date expDate;
	@JsonIgnore
	@Column(name="coupon_valid")
	private Boolean isValid = true;
	
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Double getCouponDisc() {
		return couponDisc;
	}
	public void setCouponDisc(Double couponDisc) {
		this.couponDisc = couponDisc;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
