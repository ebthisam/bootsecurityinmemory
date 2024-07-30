package com.iiht.bootsecurity.productservice;


	import java.util.Arrays;
	import java.util.List;
	import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.iiht.bootsecurity.model.Product;



//import com.iiht.feign.service.model.Product;


	@Service
	public class ProductServiceImpl implements ProductService {

		@Autowired
		private Environment environment;
		@Override
		public List<Product> findAll() {
			// TODO Auto-generated method stub
			
			return showProductList();
		}

		@Override
		public List<Product> findByCategory(String category) {
			System.out.println("<<<" + category + ">>>");
			List<Product> list = showProductList().stream().filter((product) -> (product.getCategory().equals(category)))
					.collect(Collectors.toList());

			System.out.println(list);
			String port=environment.getProperty("server.port");

			System.out.println("port"+port);
			

			
			return list;
		}
		@Override
		//@CircuitBreaker(name = "productService", fallbackMethod = "fallbackFindById")
		public Product findById(int id) {

			//return showProductList().stream().filter(product -> product.getProductId() == id).findAny().get();
			return showProductList()
	                .stream()
	                .filter(product -> product.getProductId() == id)
	                .findAny()
	                .orElseThrow(() -> new RuntimeException("Product not found"));
	    

		}
		private List<Product> showProductList() {

			return Arrays.asList(

					new Product(1, "iPhone 14", "Mobile", "Apple", 74600.00),
					new Product(2, "Split phone", "Mobile", "Samsung", 84600.00),
					new Product(3, "Grand Pixels", "Mobile", "Vivo", 45600.00),
					new Product(4, "iNSPIRON", "Laptop", "Dell", 99900.00),
					new Product(5, "Thinkpad", "Laptop", "Lenova", 64600.00),
					new Product(6, "K6 Note", "Mobile", "Lenova", 35600.00), 
					new Product(7, "Bravo", "TV", "Sony", 34600.00),
					new Product(8, "HD Smart Tv", "TV", "Samsung", 94600.00),
					new Product(9, "Ideapad", "Laptop", "Vivo", 45600.0)

			);

		}

	}




