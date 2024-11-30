package com.demo.nimap.controller;

import java.util.List;

import com.demo.nimap.model.Category;
import com.demo.nimap.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategory(@RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "2") int size) {
    	
        List<Category> categories = categoryService.getCategories(page - 1, size);
        
        if (categories.isEmpty()) {
        	
            throw new IllegalArgumentException("No categories available for the requested page.");
        }
        return categories;
    }

    @GetMapping("/{di}")
    public Category getCategoryById(@PathVariable("di") int id) {
    	
        return categoryService.getById(id)
        		
                .orElseThrow(() -> new IllegalArgumentException("Category with ID " + id + " not found"));
        
    }

    @PostMapping
    public String postCategory(@RequestBody Category category) {
    	
        return categoryService.postCategory(category);
        
    }

    @PutMapping("/{di}")
    public String updateCategoryById(@PathVariable("di") int id, @RequestBody Category category) {
    	
        return categoryService.updateCategoryById(id, category);
    }

    @DeleteMapping("/{di}")
    public String deleteByID(@PathVariable("di") int id) {
        return categoryService.deleteCategoryById(id);
    }
}

































