package org.baseapp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        printThreeWords();
        System.out.println("Задание 2:");
        checkSumSign();
        System.out.println("Задание 3:");
        printColor();
        System.out.println("Задание 4:");
        compareNumbers();
        System.out.println("Задание 5: Возвращает true/false, не сказано выводить в консоль");
        checkSumRange(10, 10);
        System.out.println("Задание 6:");
        checkNumber(-1);
        System.out.println("Задание 7: Возвращает true/false, не сказано выводить в консоль");
        booleanNumber(12);
        System.out.println("Задание 8:");
        printString("Это строка", 3);
        System.out.println("Задание 9: Возвращает true/false, не сказано выводить в консоль");
        checkYear(2026);
        System.out.println("Задание 10: Не сказано выводить в консоль");
        changeArray();
        System.out.println("Задание 11: Не сказано выводить в консоль");
        emptyArray();
        System.out.println("Задание 12: Не сказано выводить в консоль");
        multiplyArray();
        System.out.println("Задание 13: Не сказано выводить в консоль");
        squareArray(3);
        System.out.println("Задание 14: Возвращает массив, не сказано выводить в консоль");
        lenArray(3, 7);
    }


    // Задание 1
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // Задание 2
    public static void checkSumSign() {
        int a = 3, b = 6;
        if (a + b >= 0){
            System.out.println("Cумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная ");
        }
    }

    // Задание 3
    public static void printColor() {
        int value = 10;
        if (value <= 0){
            System.out.println("Красный");
        }
        else if (value <=100){
            System.out.println("Жёлтый");
        }
        else {
            System.out.println("Зелёный");
        }
    }

    // Задание 4   
    public static void compareNumbers() {
        int a = 90, b = 101;
        System.out.println("a " + (a >= b ? ">=":"<") + " b");  // ? - тернарный оператор вместо if-else
    }
    
    // Задание 5
    public static boolean checkSumRange(int x, int y) {
        boolean b = x + y >= 10 && x + y <= 20;
        return b;
    }

    // Задание 6
    public static void checkNumber(int a) {
        System.out.println(a >= 0 ? "Положительное число" : "Отрицательное число");
    }

    // Задание 7
    public static boolean booleanNumber(int a) {
        boolean b  = a < 0;     // true - если отрицательное!
        return b;
    }

    // Задание 8
    public static void printString(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    // Задание 9 (каждый 4й год - високосный, кроме 100го или каждый 400й - високосный)
    public static boolean checkYear(int year) {
        boolean b = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return(b);
    }   

    // Задание 10
    public static void changeArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0; 
        }
    }

    // Задание 11
    public static void emptyArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
    }

    // Задание 12
    public static void multiplyArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
           arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
    }

    // Задание 13
    public static void squareArray(int n) {
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
        arr[i][i] = 1;
        arr[i][n - 1 - i] = 1; // индекс столбца = n - 1 - i
        }
    }

    // Задание 14
    public static int[] lenArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}