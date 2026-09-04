package org.general;

public class TriangleArea {
        public static double triangleArea(double base, double height) {
        if (base <= 0 || height <= 0) throw new IllegalArgumentException("Стороны должны быть больше 0");
        return 0.5 * base * height;
    }
}