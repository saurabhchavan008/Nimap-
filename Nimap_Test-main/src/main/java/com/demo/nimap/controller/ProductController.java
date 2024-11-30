package com.demo.nimap.controller;

import java.util.List;

import com.demo.nimap.model.Product;
import com.demo.nimap.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products") 
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @GetMapping
    public List<Product> getProducts(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "2") int size) {
        return productService.getProducts(page, size);
    }

   // POST: Create a new product
    @PostMapping
    public String createProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

  
    @GetMapping("/{di}")
    public Product getProductById(@PathVariable(value = "di") int id) {
        return productService.getProductById(id);
    }


    @PutMapping("/{di}")
    public String updateProduct(@PathVariable(value = "di") int id, @RequestBody Product product) {
        return productService.updateById(product, id);
    }

   
    @DeleteMapping("/{di}")
    public String deleteProduct(@PathVariable(value = "di") int id) {
        return productService.deleteProduct(id);
    }
}































