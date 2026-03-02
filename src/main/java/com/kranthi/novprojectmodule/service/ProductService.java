package com.kranthi.novprojectmodule.service;

import com.kranthi.novprojectmodule.models.Category;
import com.kranthi.novprojectmodule.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getProducts();
    void updateProduct(Long id, String title, String description,Double price, String imageUrl, String category);
    Product createProduct(Long id, String title, String description, Double price, String imageurl, String category);

}
