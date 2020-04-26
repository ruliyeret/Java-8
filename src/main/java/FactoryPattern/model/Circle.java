package FactoryPattern.model;

import java.awt.*;

public class Circle {

    private Color color;

    public Circle(Color color) {
        this.color = color;
    }

    public Circle() {
        this(Color.BLACK);
    }

    @Override
    public String toString() {
        return "Circle color :" + this.color;
    }
}

