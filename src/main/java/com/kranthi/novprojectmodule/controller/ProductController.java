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
    public Product createProduct(@RequestBody Product product){
        Product p = productservice.createProduct(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(),product.getImageUrl(), product.getCategory().getTitle());
        return p;
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        Product p = productservice.getSingleProduct(id);
        return p;
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        productservice.updateProduct(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(), product.getImageUrl(), product.getCategory().getTitle());

    }
    @DeleteMapping("/products")
    public void deleteProduct(Product product){

    }

}
