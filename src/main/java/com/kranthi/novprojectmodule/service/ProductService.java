package com.kranthi.novprojectmodule.service;

import com.kranthi.novprojectmodule.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getProducts();
    void updateProduct();

}
