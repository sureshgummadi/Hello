package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="prod_table")
public class Product {
	
	@Id
	@GeneratedValue
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	private String vendorCode;
}
