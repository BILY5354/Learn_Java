package com.java.learn_han.chapter14.homework;

import java.util.ArrayList;

/**
 * @author CDUY
 * @version 1.0
 */
public class Homework2 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Car("宝马", 20000));
        arrayList.add(new Car("宾利", 60000));

        arrayList.remove(1);
        arrayList.contains(Car)
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
