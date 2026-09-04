package org.general;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTests {

    @ParameterizedTest(name = "Сложение: {0} + {1} = {2} (Индекс: {index})")
    @CsvSource({
            "10, 15, 25",
            "-3, 0, -3" })
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, Calculator.add(a, b));
    }

    @ParameterizedTest(name = "Вычитание (не равно): {0} - {1} != {2} (Индекс: {index})")
    @CsvSource({
            "15, 5, 5",
            "-15, 0, -5" })
    public void testSubtract(int a, int b, int expected) {
        assertNotEquals(expected, Calculator.subtract(a, b));
    }

    @ParameterizedTest(name = "Умножение: {0} * {1} = {2} (Индекс: {index})")
    @CsvSource({
            "10, 3, 30",
            "-15, 0, 0" })
    public void testMultiply(int a, int b, int expected) {
        assertEquals(expected, Calculator.multiply(a, b));
    }

    @ParameterizedTest(name = "Деление: {0} / {1} = {2} (Индекс: {index})")
    @CsvSource({
            "10, 5, 2",
            "-5, 1, -5" })
    public void testDivide(int a, int b, int expected) {
        assertEquals(expected, Calculator.divide(a, b));
    }

    @Test
    @DisplayName("Деление на 0")
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(10, 0));
    }
}