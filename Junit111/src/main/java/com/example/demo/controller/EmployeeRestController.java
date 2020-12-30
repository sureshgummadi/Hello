package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;

@RestController
@RequestMapping("/product")
public class EmployeeRestController {

	@Autowired
	private IProductService service;

	@PostMapping("/register")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		ResponseEntity<?> response = null;
		try {
			Integer stdId = service.saveProduct(product);
			response = new ResponseEntity<String>(stdId + "-Inserted", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> showOneProducts(@PathVariable Integer id) {
		ResponseEntity<?> response = null;
		boolean exist = service.isProductExist(id);
		if (exist) {
			Product s = service.getProductById(id);
			response = new ResponseEntity<Product>(s, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@GetMapping("/all")
	public ResponseEntity<?> showAllProducts() {
		ResponseEntity<?> response = null;
		List<Product> Products = service.getAllProducts();
		if (Products != null && !Products.isEmpty()) {
			response = new ResponseEntity<List<Product>>(Products, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		ResponseEntity<?> response = null;
		boolean exist = service.isProductExist(id);
		if (exist) {
			service.deleteProduct(id);
			response = new ResponseEntity<String>(id + "-Removed", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Product NOT FOUND", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PutMapping("/edit")
	public ResponseEntity<?> editProduct(@RequestBody Product product) {
		ResponseEntity<?> response = null;
		Integer id = product.getProdId();
		boolean exist = service.isProductExist(id);
		if (exist) {
			service.saveProduct(product);
			response = new ResponseEntity<String>(id + "-Updated", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Product NOT FOUND", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
