package com.kranthi.novprojectmodule.repository;

import com.kranthi.novprojectmodule.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // create
    Product save(Product p);

    //get Product
    @Query("select p from Product p where p.id =:Id")
    Optional<Product> findProductById(@Param("Id") Long Id);
    // get All Products
    ArrayList<Product> getAllBy();
    //delete
    void deleteProductById(Long Id);



}
