package com.promoengine.model;

public class Product {
    private String productId;
    private Double productPrice;

    public Product() {
    }

    public Product(String productId, Double productPrice) {
        this.productId = productId;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
