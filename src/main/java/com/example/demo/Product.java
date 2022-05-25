package com.example.demo;

public class Product {

    private Product(){
        super();
    }

    public Product(Long productID, String productName, Integer productPrice) {
        super();
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    private Long productID;
    private String productName;
    private Integer productPrice;

    public Long getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}
