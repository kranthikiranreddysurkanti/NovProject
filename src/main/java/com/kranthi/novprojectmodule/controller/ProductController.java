package com.kranthi.novprojectmodule.controller;

import com.kranthi.novprojectmodule.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    //CRUD apis on models;
    @PostMapping("/products")
    public void createProduct(Product product){

    }
    @GetMapping("/products")
    public String getProduct(Long id){
        return null;
    }
    @PutMapping("/products")
    public void updateProduct(Product product){

    }
    @DeleteMapping("/products")
    public void deleteProduct(Product product){

    }

}
