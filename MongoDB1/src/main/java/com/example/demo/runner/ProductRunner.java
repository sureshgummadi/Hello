package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;
import com.example.demo.rpo.ProductRepository;
@Component
public class ProductRunner implements CommandLineRunner{
	
	@Autowired
	private ProductRepository rpo;
	
	@Override
	public void run(String... args) throws Exception {
		rpo.deleteAll();
		rpo.save(new Product(10, "Mobile", 5000d));
		rpo.save(new Product(11, "Laptop", 40000d));
		rpo.save(new Product(12, "Mouse", 400d));
		rpo.save(new Product(13, "KeyBoard", 1000d));
		System.out.println("---------------");
		rpo.findAll().forEach(System.out::println);
	}

}
