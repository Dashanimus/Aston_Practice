package org.baseapp.figures;

public interface ShapeInterface {
    String getFillColor();
    String getBorderColor();

    double getArea();

    double[] getSides();

    default double getPerimeter() {
        double perimeter = 0;
        for (double side : getSides()) {
            perimeter += side;
        }
        return perimeter;
    }

    default void getInfo() {
        System.out.printf("Фигура: " + this.getClass().getSimpleName() 
        + " | Периметр: " + getPerimeter() 
        + " | Площадь: " + getArea()
        + " | Цвет фона: " + getFillColor()
        + " | Цвет границ: " + getBorderColor()
        + "\n");
    }
}