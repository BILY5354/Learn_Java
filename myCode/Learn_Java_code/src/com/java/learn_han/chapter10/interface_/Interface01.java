package com.java.learn_han.chapter10.interface_;

public class Interface01 {
    public static void main(String[] args) {
        Camera camera = new Camera();
        Phone phone = new Phone();

        Computer computer = new Computer();
        computer.work(camera);//把相机接入电脑
        System.out.println("===========");
        computer.work(phone);//把手机接入电脑
    }
}
