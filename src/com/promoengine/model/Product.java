package com.promoengine.model;

public class Product {
    private String productId;
    private Double productPrice;

    public Product() {
    }

    public Product(String productId) {
        this.productId = productId;
        switch (productId){
            case "A":
                this.productPrice = 50.00;
                break;
            case "B":
                this.productPrice = 30.00;
                break;
            case "C":
                this.productPrice = 20.00;
                break;
            case "D":
                this.productPrice = 15.00;
                break;
        }
    }

    public String getProductId() {
        return productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }
}
