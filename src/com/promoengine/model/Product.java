package com.promoengine.model;

public class Product {
    private String productId;
    private Integer productPrice;

    public Product() {
    }

    public Product(String productId) {
        this.productId = productId;
        switch (productId) {
            case "A":
                this.productPrice = 50;
                break;
            case "B":
                this.productPrice = 30;
                break;
            case "C":
                this.productPrice = 20;
                break;
            case "D":
                this.productPrice = 15;
                break;
        }
    }

    public String getProductId() {
        return productId;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    // TODO: 05/10/2021  
    //we can add more products and configure product prices here as an additional functionality
}
