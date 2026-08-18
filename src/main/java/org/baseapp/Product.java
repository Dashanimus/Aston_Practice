package org.baseapp;

public class Product {
    private String productName;
      private String manufactureDate;
      private String manufacturer; 
      private String originCountry;
      private int price;
      private boolean isReserved;   

    Product(String productName, String manufactureDate, String manufacturer, String originCountry, int price, boolean isReserved) {
        this.productName = productName;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.originCountry = originCountry;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInfo() {
        System.out.println("--- Информация о товаре ---");
        System.out.println("Название: " + productName);
        System.out.println("Дата производства: " + manufactureDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + originCountry);
        System.out.println("Цена: " + price);
        System.out.println("Cостояние бронирования покупателем: " + isReserved);
        System.out.println("\n");
    }
}
