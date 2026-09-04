package org.general;

import static org.testng.Assert.*;

import org.testng.annotations.*;

public class CalculatorTests {

    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][] {
                { 10, 5, 15 },
                { -5, 0, -5 }
        };
    }

    @Test(dataProvider = "addData", description = "Тест сложения чисел")
    public void testAdd(int a, int b, int expected) {
        assertEquals(Calculator.add(a, b), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][] {
                { 10, 5, 5 },
                { -5, 0, -5 }
        };
    }

    @Test(dataProvider = "subtractData", description = "Тест вычитания чисел")
    public void testSubtract(int a, int b, int expected) {
        assertEquals(Calculator.subtract(a, b), expected);
    }

    @DataProvider(name = "multiplyData")
    public Object[][] multiplyData() {
        return new Object[][] {
                { 10, 5, 50 },
                { -5, 0, 0 }
        };
    }

    @Test(dataProvider = "multiplyData", description = "Тест умножения чисел")
    public void testMultiply(int a, int b, int expected) {
        assertEquals(Calculator.multiply(a, b), expected);
    }

    @DataProvider(name = "divideData")
    public Object[][] divideData() {
        return new Object[][] {
                { 10, 5, 2.0 },
                { -5, 1, -5.0 }
        };
    }

    @Test(dataProvider = "divideData", description = "Тест деления чисел")
    public void testDivide(int a, int b, double expected) {
        assertEquals(Calculator.divide(a, b), expected, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator.divide(10, 0);
    }
}