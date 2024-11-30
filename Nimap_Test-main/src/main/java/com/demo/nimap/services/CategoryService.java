package com.demo.nimap.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.nimap.model.Category;
import com.demo.nimap.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	
	public List<Category> getCategories(int pageNumber,int pageSize) {
		
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		List<Category> list =categoryRepository.findAll(pageable).getContent();
		
		
		
		return list;
		
	}
	
	public Optional<Category> getById(int id) {
		
		
		return categoryRepository.findById(id);
		
	}
	
	
	
	public String postCategory(Category category) {
		
		
		categoryRepository.save(category);
		
		return "inserted";
	}
	
	public String updateCategoryById(int id,Category category) {
		
		Category dbcategory=categoryRepository.findById(id).get();
		
		
		
		if(dbcategory!=null) {
			dbcategory.setC_id(category.getC_id());
			categoryRepository.save(category);
			return "Updated" ;
			
		}else return "Category not found";
				
		
		
	}
	
	
	public String updateCategory(Category category,int id) {
		
		
		Category dbcategory=categoryRepository.findById(id).get();
		
		if(dbcategory.equals(null)) {
			
			return "Category not found ";
			
		}
		else {
			category.setC_id(dbcategory.getC_id());
			
			
			categoryRepository.save(category);
			
		}
		
		return "Updated" ;
		
	}
	
	public String deleteCategoryById(int id) {
		
		categoryRepository.deleteById(id);
		
		return "Deleted";
		
	}
	
	

}





















