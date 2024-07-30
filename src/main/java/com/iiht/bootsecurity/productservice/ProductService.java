package com.iiht.bootsecurity.productservice;

import java.util.List;

import com.iiht.bootsecurity.model.Product;



public interface ProductService {
	
	List<Product> findAll();
	List<Product> findByCategory(String category);
	Product findById(int id);

}
