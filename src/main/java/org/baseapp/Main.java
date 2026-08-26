package org.baseapp;

import org.baseapp.MyArrayExceptions.MyArrayDataException;
import org.baseapp.MyArrayExceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        
        String[][] correctArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "1", "2", "3"},
            {"4", "5", "6", "7"}
        };

        String[][] incorrectSizeArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15"}
        };

        String[][] incorrectDataArray = {
            {"text", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"}
        };

        MyArrayValidator validator = new MyArrayValidator();

        try {
            int result = validator.processArray(correctArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
         
        try {
            int result = validator.processArray(incorrectSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            int result = validator.processArray(incorrectDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            String element = correctArray[0][7];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}