package com.promoengine.service;

import com.promoengine.exceptions.InvalidProductTypeException;
import com.promoengine.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderProcessingService {
    public static final String[] AVAILABLE_PRODUCTS = {"A", "B", "C", "D"};

    public List<Product> addPromotions(int totalOrders) throws InvalidProductTypeException {

        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < totalOrders; i++) {
            System.out.println("Enter the type of product among the available products  : " + Arrays.toString(AVAILABLE_PRODUCTS));
            Scanner scanner = new Scanner(System.in);
            String type = scanner.next().toUpperCase();
            if (Arrays.asList(AVAILABLE_PRODUCTS).contains(type)) {
                Product product = new Product(type.toUpperCase());
                productList.add(product);
            } else
                throw new InvalidProductTypeException("Product type : '" + type + "' is invalid");

        }
        return productList;
    }

    public int calculateTotal(List<Product> productList) {
        int countA = 0;
        int priceOfA = 50;

        int countB = 0;
        int priceOfB = 30;

        int countC = 0;
        int priceOfC = 20;

        int countD = 0;
        int priceOfD = 15;

        for (Product p : productList) {
            if (p.getProductId().equalsIgnoreCase("A")) {
                countA = countA + 1;
            } else if (p.getProductId().equalsIgnoreCase("B")) {
                countB = countB + 1;
            } else if (p.getProductId().equalsIgnoreCase("C")) {
                countC = countC + 1;
            } else {
                countD = countD + 1;
            }
        }

        int totalPriceOfA = (countA / 3) * 130 + (countA % 3 * priceOfA);
        int totalPriceOfB = (countB / 2) * 45 + (countB % 2 * priceOfB);
        int combinedPrice = 0;
        int noOfPairs = 0;
        int remainingCount = 0;
        if (countC >= 1 && countD >= 1) {
            if (countC > countD) {
                noOfPairs = countD;
                remainingCount = (countC + countD) - (noOfPairs * 2);
                combinedPrice = noOfPairs * 30 + (remainingCount * 20);
            } else if (countD > countC) {
                noOfPairs = countC;
                remainingCount = (countC + countD) - (noOfPairs * 2);
                combinedPrice = noOfPairs * 30 + (remainingCount * 15);
            } else {
                noOfPairs = countC;
                combinedPrice = noOfPairs * 30;
            }
            return totalPriceOfA + totalPriceOfB + combinedPrice;
        } else {
            int totalPriceOfC = (countC * priceOfC);
            int totalPriceOfD = (countD * priceOfD);
            return totalPriceOfA + totalPriceOfB + totalPriceOfC + totalPriceOfD;
        }
    }
}
