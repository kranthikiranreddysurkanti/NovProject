package com.kranthi.novprojectmodule.Dto;

import com.kranthi.novprojectmodule.models.Category;
import com.kranthi.novprojectmodule.models.Product;

public class FakeStoreProductServiceDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;

    public Product getProduct(){
        Product p = new Product();
        p.setId(id);
        p.setTitile(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageUrl(image);
        Category c = new Category();
        c.setTitle(category);
        p.setCategory(c);
        return p;
    }
}
