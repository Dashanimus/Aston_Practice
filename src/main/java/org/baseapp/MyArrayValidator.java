package org.baseapp;

import org.baseapp.MyArrayExceptions.MyArrayDataException;
import org.baseapp.MyArrayExceptions.MyArraySizeException;

public class MyArrayValidator {
    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array == null || array.length != 4) { 
        throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) { 
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}