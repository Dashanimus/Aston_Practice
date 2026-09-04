package org.general;

import static org.testng.Assert.*;

import org.testng.annotations.*;

public class NumberComparatorTests {

    @Test
    public void testIsEqual() {
        assertTrue(NumberComparator.isEqual(5, 5));
        assertFalse(NumberComparator.isEqual(5, 6));
    }
    @Test
    public void testIsGreater() {
        assertTrue(NumberComparator.isGreater(10, 5));
        assertFalse(NumberComparator.isGreater(5, 10));
    }

    @Test
    public void testIsLess() {
        assertTrue(NumberComparator.isLess(3, 7));
        assertFalse(NumberComparator.isLess(7, 3));
        assertFalse(NumberComparator.isLess(5, 5));
    }

    @Test
    public void testMax() {
        assertEquals(NumberComparator.max(10, 5), 10);
        assertEquals(NumberComparator.max(5, 10), 10);
        assertEquals(NumberComparator.max(5, 5), 5);
    }

    @Test
    public void testMin() {
        assertEquals(NumberComparator.min(10, 5), 5);
        assertEquals(NumberComparator.min(5, 10), 5);
        assertEquals(NumberComparator.min(5, 5), 5);
    }
}