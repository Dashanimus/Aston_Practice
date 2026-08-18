package org.baseapp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        printThreeWords();
        System.out.println("Задание 2:");
        checkSumSign();
        System.out.println("Задание 3:");
        printColor(10);
        System.out.println("Задание 4:");
        compareNumbers(90, 101);
        System.out.println("Задание 5:");
        checkSumRange(10, 10);
        System.out.println("Задание 6:");
        checkNumber(-1);
        System.out.println("Задание 7:");
        booleanNumber(12);
        System.out.println("Задание 8:");
        printString("Это строка", 3);
        System.out.println("Задание 9:");
        checkYear(2026);
        System.out.println("Задание 10:");
        changeArray();
        System.out.println("Задание 11:");
        emptyArray();
        System.out.println("Задание 12:");
        multiplyArray();
        System.out.println("Задание 13:");
        squareArray(3);
        System.out.println("Задание 14:");
        lenArray(3, 7);
    }


    // Задание 1
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // Задание 2
    public static void checkSumSign() {
        int a = 3, b = 6, sum = a + b;
        if (sum >= 0){
            System.out.println("Cумма положительная " + "(" + sum + ")");
        }
        else {
            System.out.println(sum + "Сумма отрицательная " + "(" + sum + ")");
        }
    }

    // Задание 3
    public static void printColor(int value) {
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
    public static void compareNumbers(int a, int b) {
        System.out.println("a " + (a >= b ? ">=":"<") + " b");  // ? - тернарный оператор вместо if-else
    }
    
    // Задание 5
    public static boolean checkSumRange(int x, int y) {
        int sum = x + y;
        boolean b = sum >= 10 && sum <= 20;
        System.out.println(b);
        return b;
    }

    // Задание 6
    public static void checkNumber(int a) {
        System.out.println("a = " + a + (a >= 0 ? " -> положительное число" : " -> отрицательное число"));
    }

    // Задание 7
    public static boolean booleanNumber(int a) {
        boolean b  = a < 0;     // true - если отрицательное!
        System.out.println(b);
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
        System.out.println(b);
        return(b);
    }   

    // Задание 10
    public static void changeArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0; 
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 11
    public static void emptyArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        for (int i : arr) {
        System.out.print(i + " ");
        }
        System.out.println();
    }

    // Задание 12
    public static void multiplyArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
           arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 13
    public static void squareArray(int n) {
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
        arr[i][i] = 1;
        arr[i][n - 1 - i] = 1; // индекс столбца = n - 1 - i
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
        }
    }

    // Задание 14
    public static int[] lenArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}