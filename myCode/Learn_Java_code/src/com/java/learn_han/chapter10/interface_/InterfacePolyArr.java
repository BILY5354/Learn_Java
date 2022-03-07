package com.java.learn_han.chapter10.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {

        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone1();
        usbs[1] = new Camera_();

        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();//运行时的多态

            if (usbs[i] instanceof Phone1) {
                ((Phone1) usbs[i]).call();//向下转型
            }
        }
    }
}

interface Usb {
    void work();
}

class Phone1 implements Usb {

    public void call() {
        System.out.println("calling");
    }

    @Override
    public void work() {
        System.out.println("手机工作中");
    }
}

class Camera_ implements Usb {

    @Override
    public void work() {
        System.out.println("相机工作中");
    }
}
