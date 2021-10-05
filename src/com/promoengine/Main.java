package com.promoengine;

import com.promoengine.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("PROMOTION ENGINE HAS BEEN STARTED");
        System.out.println("How many order you want to process?"); //instead of System.out.println() we can use loggers as well.
        List<Product> productList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int totalOrders = sc.nextInt();
        for (int i = 0; i < totalOrders; i++) {
            System.out.println("Enter the type of product ( A,B,C,D)");
            Scanner scanner = new Scanner(System.in);
            String type = scanner.next();
            Product product = new Product(type);
            productList.add(product);
        }
        double totalPrice = calculateTotal(productList);
        System.out.println("Total Price of your all items is : " + totalPrice);
    }

    public static double calculateTotal(List<Product> productList) {
        int countA = 0;
        double priceOfA = 50.00;

        int countB = 0;
        double priceOfB = 30.00;

        int countC = 0;
        double priceOfC = 20.00;

        int countD = 0;
        double priceOfD = 15.00;

        for (Product p : productList) {
            if (p.getProductId().equalsIgnoreCase("A")) {
                countA = countA + 1;
            } else if (p.getProductId().equalsIgnoreCase("B")) {
                countB = countA + 1;
            } else if (p.getProductId().equalsIgnoreCase("C")) {
                countC = countA + 1;
            } else {
                countD = countA + 1;
            }
        }

        double totalPriceOfA = (countA / 3.00) * 130 + countA % 3 * priceOfA;
        double totalPriceOfB = (countB / 2.00) * 45 + countB % 3 * priceOfB;
        double totalPriceOfC = countC * priceOfC;
        double totalPriceOfD = countD * priceOfD;
        return totalPriceOfA + totalPriceOfB + totalPriceOfC + totalPriceOfD;
    }
}
