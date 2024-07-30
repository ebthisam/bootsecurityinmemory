package com.iiht.bootsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	
	Integer productId;
	String name;
	String brand;
	String category;
	Double price;
	

}

