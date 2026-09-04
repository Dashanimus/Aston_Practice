package org.general;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleAreaTests {
    @Test
    @DisplayName("Площадь треугольника - Норма")
    public void testAreaNormal() {
        assertEquals(15.0, TriangleArea.area(5.0, 6.0));
    }

    @Test
    @DisplayName("Площадь треугольника - Основание <= 0")
    public void testAreaNegativeBase() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.area(-5.0, 4.0));
    }

    @Test
    @DisplayName("Площадь треугольника - Высота <= 0")
    public void testAreaNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.area(5.0, 0.0));
    }
}