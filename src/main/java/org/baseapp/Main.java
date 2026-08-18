package org.baseapp;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", 
        "01.02.2025", 
        "Samsung Corp.", 
        "Korea", 
        5599, 
        true);

        productsArray[1] = new Product("iPhone 16 Pro", 
        "15.09.2024", 
        "Apple Inc.", 
        "USA", 
        115000, 
        false);
        
        productsArray[2] = new Product("Televisor 4K OLED", 
        "10.11.2025", 
        "LG Electronics", 
        "Korea", 
        95000, 
        false);

        productsArray[3] = new Product("Wireless Headphones", 
        "22.01.2026", 
        "Sony", 
        "Japan", 
        24000, 
        true);

        productsArray[4] = new Product("HONOR CHOICE Earbuds X5 Pro", 
        "10.10.2024", 
        "Wingtech Mobile Communications Co.", 
        "China", 
        55000, 
        false);

        System.out.println("--- СПИСОК ТОВАРОВ ---\n");
        for (Product currentProduct : productsArray) {
            currentProduct.printInfo();
        }
    }
}