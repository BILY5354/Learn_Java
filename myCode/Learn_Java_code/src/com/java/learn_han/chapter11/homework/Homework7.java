package com.java.learn_han.chapter11.homework;

/**
 * @author CDUY
 * @version 1.0
 */
public class Homework7 {
    public static void main(String[] args) {
        //方式1
        Car car1 = new Car(20);
        Car.Air air1 = car1.new Air();
        air1.flow();

        //方式2
        Car.Air air2 = new Car(-10).new Air();
        air2.flow();

        //方式3
        Car.Air air3 = new Car(40).getAirInstance();
        air3.flow();


    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public class Air {
        public void flow() {
            if (Car.this.temperature >= 40) {
                System.out.println("吹冷气");
            } else if (Car.this.temperature <= 0) {
                System.out.println("吹暖气");
            } else {
                System.out.println("关空调");
            }
        }
    }
    //用于方式3
    public Air getAirInstance() {
        return new Air();
    }
}
