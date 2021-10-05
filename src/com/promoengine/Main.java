package com.promoengine;

import com.promoengine.exceptions.InvalidOrderNumberException;
import com.promoengine.model.Product;
import com.promoengine.service.OrderProcessingService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("PROMOTION ENGINE HAS BEEN STARTED");
        System.out.println("How many order you want to process?"); //instead of System.out.println() we can use loggers as well.
        Scanner sc = new Scanner(System.in);
        int totalOrders = sc.nextInt();
        OrderProcessingService orderProcessingService = new OrderProcessingService();
        if (totalOrders > 0) {
            List<Product> productList = orderProcessingService.addPromotions(totalOrders);
            int totalPrice = productList.size() > 0 ? orderProcessingService.calculateTotal(productList) : 0;
            System.out.println("Total Price of your all items is : " + totalPrice);
        } else {
            throw new InvalidOrderNumberException("Order number should be greater than 0");
        }
    }
}
