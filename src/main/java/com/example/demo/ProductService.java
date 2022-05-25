package com.example.demo;

import java.util.List;

import com.example.demo.Product;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(Long id);
    void createProduct(Long productID, String productName, Integer productPrice);
    void deleteProduct(Long id);
}
