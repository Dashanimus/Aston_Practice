package org.general;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class NumberComparatorTests {

    @Test
    @DisplayName("Числа равны")
    public void testIsEqual() {
        assertTrue(NumberComparator.isEqual(5, 5));
        assertFalse(NumberComparator.isEqual(5, 6));
    }

    @Test
    @DisplayName("Первое число больше второго")
    public void testIsGreater() {
        assertTrue(NumberComparator.isGreater(10, 5));
        assertFalse(NumberComparator.isGreater(5, 10));
    }

    @Test
    @DisplayName("Первое число меньше второго")
    public void testIsLess() {
        assertTrue(NumberComparator.isLess(3, 7));
        assertFalse(NumberComparator.isLess(7, 3));
        assertFalse(NumberComparator.isLess(5, 5));
    }

    @Test
    @DisplayName("Большее число")
    public void testMax() {
        assertEquals(10, NumberComparator.max(10, 5));
        assertEquals(10, NumberComparator.max(5, 10));
        assertEquals(5, NumberComparator.max(5, 5));
    }

    @Test
    @DisplayName("Меньшее число")
    public void testMin() {
        assertEquals(5, NumberComparator.min(10, 5));
        assertEquals(5, NumberComparator.min(5, 10));
        assertEquals(5, NumberComparator.min(5, 5));
    }
}