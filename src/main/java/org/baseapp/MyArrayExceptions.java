package org.baseapp;

public class MyArrayExceptions {

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException() {
            super("Размер массива должен быть 4x4");
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(int row, int col) {
            super("Некорректные данные в ячейке [" + row + "][" + col + "]");
        }
    } 
}