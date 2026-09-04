package org.general;

import static org.testng.Assert.*;

import org.testng.annotations.*;

public class FactorialTests {

    @Test
    public void testFactorialEquals() {
        assertEquals(Factorial.calculate(3), 6);
    }

    @Test
    public void testFactorialNotEquals() {
        assertNotEquals(Factorial.calculate(10), 3628880);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Factorial.calculate(-5);
    }
}