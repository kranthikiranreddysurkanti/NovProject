package com.kranthi.novprojectmodule.service;

import com.kranthi.novprojectmodule.exceptions.ProductNotFoundException;
import com.kranthi.novprojectmodule.models.Category;
import com.kranthi.novprojectmodule.models.Product;
import com.kranthi.novprojectmodule.repository.CategoryRepository;
import com.kranthi.novprojectmodule.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findProductById(id);
        if(p.isPresent()){
            return p.get();
        }
        throw new ProductNotFoundException("product is not found in db");
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return null;
    }

    @Override
    public void updateProduct(Long id, String title, String description, Double price, String imageUrl) {

    }

    @Override
    public Product createProduct(Long id, String title, String description, Double price, String imageurl, String category) {
        Product p = new Product();
        Optional<Category> currcat = categoryRepository.findCategoryByTitle(category);
        if(currcat.isEmpty()){
            Category newcat = new Category();
            newcat.setTitle(category);
            Category newrow = categoryRepository.save(newcat);
            p.setCategory(newrow);
        }
        else{
            Category c = currcat.get();
            p.setCategory(c);
        }
        p.setDescription(description);
        p.setTitle(title);
        p.setPrice(price);
        p.setImageUrl(imageurl);
        Product saveprod = productRepository.save(p);
        return saveprod;

    }

    @Override
    public void deleteProduct(Long id) {

    }
}
