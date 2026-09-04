package org.general;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class FactorialTests {

    @Test
    @DisplayName("Факториал - Равенство")
    public void testFactorialEquals() {
        assertEquals(1, Factorial.calculate(1));
    }

    @Test
    @DisplayName("Факториал - Неравенство")
    public void testFactorialNotEquals() {
        assertNotEquals(3628880, Factorial.calculate(10));
    }

    @Test
    @DisplayName("Факториал - Отрицательное число")
    public void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-3));
    }
}