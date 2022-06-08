package com.example.demo;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(Long id);
    Product createProduct(Long productID, String productName, Integer productPrice);
    Integer deleteProduct(Long id);
    Integer modifyProductPrice(Long id);
}
