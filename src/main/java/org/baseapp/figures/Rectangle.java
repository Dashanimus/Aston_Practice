package org.baseapp.figures;

public class Rectangle extends BaseFigure implements ShapeInterface {
    private double length;
    private double width;

    public Rectangle(double length, double width, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double[] getSides() {
        return new double[]{length, length, width, width};
    }

    @Override
    public String getFillColor() { return fillColor; }

    @Override
    public String getBorderColor() { return borderColor; }
}
