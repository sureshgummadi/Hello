package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
@Service
public interface ProductService {
	public Product saveProduct(Product product);
	public Product updateProduct(Product product);
	public Product getProductById(Integer id);
	public void deleteProductById(Integer id);
	public List<Product> getAllProducts();
	public boolean isExist(Integer id);
	public Double calculateDiscount(Double cost,Double disc);
}
