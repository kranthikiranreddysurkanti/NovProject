package com.kranthi.novprojectmodule.service;

import com.kranthi.novprojectmodule.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    public Product getSingleProduct(Long id) {
        System.out.println("in the get single product method");
        return null;
    }

    public List<Product> getProducts() {
        return List.of();
    }

    public void updateProduct() {

    }
}
