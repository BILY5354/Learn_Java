package com.java.learn_han.chapter11.homework;

import com.java.learn_han.chapter8.polyparameter.PloyParameter;
import com.java.learn_han.chapter9.copy_han.domain.House;

/**
 * @author CDUY
 * @version 1.0
 */
public class Homework6 {
    public static void main(String[] args) {
        Person tz = new Person("唐曾", new Horse());
        tz.common();
        tz.passRiver();
        tz.passFireHill();
        tz.common();
    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles{

    @Override
    public void work() {
        System.out.println("载具马，走路中");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("载具船，过河了");
    }
}

class Plane implements Vehicles {

    @Override
    public void work() {
        System.out.println("载具飞机，飞天了");
    }
}

class VehiclesFactory {

    private static Horse horse = new Horse();//饿汉式 使马儿始终是同一匹

    private VehiclesFactory() {}

    public static Horse getHorse() {//这里，我们将方法做成static 就可以直接调用了
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
    public static Plane getPlane() {
        return new Plane();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void common() {
        if (!(vehicles instanceof  Horse)) {
            vehicles = VehiclesFactory.getHorse();//向上转型 父类引用指向子类使可以调用子类的方法
            //相当于 vehicles = house; 这里的 house 是 static 所以没有 new
        }
        vehicles.work();
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
            //相当于 vehicles = new Boat();
        }
        vehicles.work();
    }

    public void passFireHill() {
        if (!(vehicles instanceof Plane)) {
            vehicles = VehiclesFactory.getPlane();
        }
        vehicles.work();
    }
}