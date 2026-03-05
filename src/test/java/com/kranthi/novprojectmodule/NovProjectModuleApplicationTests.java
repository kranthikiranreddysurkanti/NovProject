package com.kranthi.novprojectmodule;

import com.kranthi.novprojectmodule.models.Product;
import com.kranthi.novprojectmodule.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class NovProjectModuleApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void queryTest(){
        Optional<Product> p = productRepository.findProductById(2L);
        System.out.println(p.get().toString());
    }
}
