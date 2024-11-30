package com.demo.nimap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.nimap.model.Product;
import com.demo.nimap.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	public List<Product> getProducts(int pageNumber,int pageSize) {
		
		
		
	
		
		Pageable pageable= PageRequest.of(pageNumber, pageSize);
		
		Page<Product> allproduct=productRepository.findAll(pageable);
		

		 return allproduct.getContent();
	}
	
	
	public Product getProductById(int id) {
		
		Product product= productRepository.findById(id).get();
		
		
		if(product !=null) {
			
			
			return product;
			
		}
		else return null;
		
	}
	
	
	public String insertProduct(Product product) {
		
		
		productRepository.save(product);
		return "Product inserted";
		
	}
	
	
	
	public String updateById(Product product , int id) {
		
		Product dbproduct=productRepository.findById(id).get();
		
		if(dbproduct!=null) {
			
			
			dbproduct.setId(id);
			
			productRepository.save(dbproduct);
			
			return "Product Updated";
			
		}
		else return "Existing product not find";
		
		
		
	}
	
	
	public String deleteProduct(int id) {
		
		
		
		productRepository.deleteById(id);
		
		return "Product deleted";
		
	}
	
	

}
























