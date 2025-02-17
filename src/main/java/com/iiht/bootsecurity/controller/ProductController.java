package com.iiht.bootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.bootsecurity.model.Product;
import com.iiht.bootsecurity.productservice.ProductService;



@RestController

	@RequestMapping("/product-service")

	public class ProductController {

	


		@Autowired

		ProductService product;

		
		@PreAuthorize(value="hasRole('ADMIN')")
		@GetMapping("/products")

		public List<Product> findAll(){
			
		return product.findAll();

		}

		@GetMapping("/products-by-category/{category}")

		public List<Product> findByCategory(@PathVariable("category") String category){

			return product.findByCategory(category);

			

		}

		
		@GetMapping("/products-by-id/{id}")

		public Product findById(@PathVariable("id") int id) {

			return product.findById(id);

			

		}



	}






