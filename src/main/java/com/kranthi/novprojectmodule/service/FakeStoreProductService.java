package com.kranthi.novprojectmodule.service;

import com.kranthi.novprojectmodule.Dto.FakeStoreProductDto;
import com.kranthi.novprojectmodule.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Product getSingleProduct(Long id) {
        System.out.println("in the get single product method");
        FakeStoreProductDto fakestoreproductdto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        System.out.println("ending the single product");
        return fakestoreproductdto.getProduct();
    }

    public List<Product> getProducts() {
        return List.of();
    }


    public void updateProduct(Long id, String title, String description, Double price, String imageUrl, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);
        restTemplate.put("https://fakestoreapi.com/products" + id, fakeStoreProductDto);
        System.out.println("product is updated successfully");
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

}
