package com.java.learn_han.chapter10.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        System.out.println(new Circle(5.0).calArea());
    }
}

class Circle {
    private double radius;
    private final double PI1 = 3.14;
    private final double PI2;
    private final double PI3;

    {
        PI3 = 3.14;
    }

    public Circle(double radius) {
        this.radius = radius;
        PI2 = 31.4;
    }

    public double calArea() {
        return radius * radius * PI1;
    }
}