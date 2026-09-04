package org.general;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    @Test
    @DisplayName("Tест калькулятор")
    void testArithmeticActions() {
        assertEquals(10, MathOperations.add(7, 3));
        assertEquals(4, MathOperations.subtract(7, 3));
        assertEquals(21, MathOperations.multiply(7, 3));
        assertEquals(2.5, MathOperations.divide(5, 2), 0.001);
        assertThrows(ArithmeticException.class, () -> MathOperations.divide(5, 0));
    }
}