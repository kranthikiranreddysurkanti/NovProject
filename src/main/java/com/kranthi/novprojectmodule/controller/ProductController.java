package com.kranthi.novprojectmodule.controller;

import com.kranthi.novprojectmodule.Dto.ErrorDto;
import com.kranthi.novprojectmodule.exceptions.ProductNotFoundException;
import com.kranthi.novprojectmodule.models.Product;
import com.kranthi.novprojectmodule.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product p = productservice.getSingleProduct(id);
        ResponseEntity<Product> response = new ResponseEntity<>(p, HttpStatus.OK);
        return response;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> ProductNotFoundExceptionHandling(Exception e){
        ErrorDto error = new ErrorDto();
        error.setMessage(e.getMessage());
        ResponseEntity<ErrorDto> response = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return response;
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        productservice.updateProduct(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(), product.getImageUrl());
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productservice.deleteProduct(id);
    }
    @GetMapping("/products")
    public ArrayList<Product> getProducts(){
        ArrayList<Product> p = productservice.getAllProducts();
        return p;
    }
}
