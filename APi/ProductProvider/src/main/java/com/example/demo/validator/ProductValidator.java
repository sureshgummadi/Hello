package com.example.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.util.StringUtils;

import com.example.demo.model.Product;
import com.example.demoexception.ApiError;

@Component
public class ProductValidator implements Validator {
	/*
	 * @Autowired private ApiError api;
	 */

	@Override
	public boolean supports(Class<?> clazz) {
	return clazz.equals(Product.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void validate(Object target, Errors errors) {
	Product p = (Product) target;
	ApiError api = new ApiError();
		if(StringUtils.isEmpty(p.getProdId().toString())) {
		errors.reject("prodId");
		api.getValidationErrors().add("Please Provide Product Id");
		}
		if(StringUtils.isEmpty(p.getProdCode())) {
		errors.reject("prodCode");
		api.getValidationErrors().add("Please Provide Product Code ");
		}
		if(StringUtils.isEmpty(p.getProdCost().toString())) {
		errors.reject("prodCost");
		api.getValidationErrors().add("Please Provide Product Cost ");
		}
	}
}

