package com.kranthi.novprojectmodule.controller;

import com.kranthi.novprojectmodule.models.Product;
import com.kranthi.novprojectmodule.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    //CRUD apis on models;
    private ProductService productservice;

    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }

    @PostMapping("/products")
    public void createProduct(Product product){

    }
    @GetMapping("/products/{id}")
    public String getProduct(Long id){
        productservice.getSingleProduct(id);
        return null;
    }
    @PutMapping("/products")
    public void updateProduct(Product product){

    }
    @DeleteMapping("/products")
    public void deleteProduct(Product product){

    }

}
