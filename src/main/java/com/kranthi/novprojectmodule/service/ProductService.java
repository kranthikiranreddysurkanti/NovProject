package com.kranthi.novprojectmodule.service;

import com.kranthi.novprojectmodule.exceptions.ProductNotFoundException;
import com.kranthi.novprojectmodule.models.Category;
import com.kranthi.novprojectmodule.models.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    ArrayList<Product> getAllProducts();
    void updateProduct(Long id, String title, String description,Double price, String imageUrl);
    Product createProduct(Long id, String title, String description, Double price, String imageurl, String category);
    void deleteProduct(Long id);
}
