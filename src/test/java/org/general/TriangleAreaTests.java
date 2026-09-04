package org.general;

import static org.testng.Assert.*;

import org.testng.annotations.*;

public class TriangleAreaTests {
    @Test
    public void testAreaNormal() {
        assertEquals(TriangleArea.area(5.0, 6.0), 15.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaNegativeBase() {
        TriangleArea.area(-5.0, 4.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaNegativeHeight() {
        TriangleArea.area(5.0, -4.0);
    }
}