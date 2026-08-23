package org.baseapp.figures;

public abstract class BaseFigure {
    protected String fillColor;
    protected String borderColor;

    public BaseFigure(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
}