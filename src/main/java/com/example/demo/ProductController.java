package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController{

    @Autowired
    ProductService productservice;

    @GetMapping("")
    List<Product> getProducts(){
        return productservice.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productservice.getProduct(id);
    }

    @PostMapping(value = "")
    public Map<String, Object> createProduct(@RequestParam(value = "id") Long id,
                                             @RequestParam(value = "name") String name, @RequestParam(value = "price") Integer price) {
        productservice.createProduct(id, name, price);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "Product added!");
        return map;
    }
}
