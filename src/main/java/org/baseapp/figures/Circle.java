package org.baseapp.figures;

public class Circle extends BaseFigure implements ShapeInterface {
    private double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double[] getSides() {
        return new double[]{2 * Math.PI * radius};
    }

    @Override
    public String getFillColor() {
        return fillColor; 
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
