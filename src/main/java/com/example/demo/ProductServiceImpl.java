package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.demo.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    public  ProductServiceImpl() {
        products.add(new Product(1l, "product_1", 1001));
        products.add(new Product(2l, "product_2", 1002));
        products.add(new Product(3l, "product_3", 1003));
    }

    List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(Long id) {
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()) {;
            Product product = iterator.next();
            System.out.println(product.getProductID());
            if (product.getProductID().equals(id)) {
                return product;
            }
        }

        return null;
    }

    public void createProduct(Long productID, String productName, Integer productPrice) {
        products.add(new Product(productID, productName, productPrice));
    }

    public void deleteProduct(Long id) {
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()) {;
            Product product = iterator.next();
            System.out.println(product.getProductID());
            if (product.getProductID().equals(id)) {
                products.remove(product);
                break;  // remove changes the len of the list and breaks the iterator
            }
        }
    }

}
