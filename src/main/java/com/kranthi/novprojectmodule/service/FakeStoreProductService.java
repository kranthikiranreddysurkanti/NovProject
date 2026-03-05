package com.kranthi.novprojectmodule.service;

import com.kranthi.novprojectmodule.Dto.FakeStoreProductDto;
import com.kranthi.novprojectmodule.exceptions.ProductNotFoundException;
import com.kranthi.novprojectmodule.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Product getSingleProduct(Long id) throws ProductNotFoundException{
        System.out.println("in the get single product method");
        FakeStoreProductDto fakestoreproductdto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        System.out.println("ending the single product");
        if(fakestoreproductdto == null){
            throw new ProductNotFoundException("no product is found");
        }
        return fakestoreproductdto.getProduct();
    }

    @Override
    public ArrayList<Product> getAllProducts() {
       return null;
    }

    public void updateProduct(Long id, String title, String description, Double price, String imageUrl) {
        FakeStoreProductDto response = new FakeStoreProductDto();
        response.setTitle(title);
        response.setDescription(description);
        response.setPrice(price);
        response.setImage(imageUrl);
        restTemplate.put("https://fakestoreapi.com/products/" + id, response);
        System.out.println("put operation is successful");
    }

    public Product createProduct(Long id, String title, String description, Double price, String imageurl, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageurl);
        fakeStoreProductDto.setCategory(category);
        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
        System.out.println(response.toString());
        return response.getProduct();
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("delete is done successfully");
    }

}
