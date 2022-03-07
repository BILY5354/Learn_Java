package com.java.learn_han.chapter10.interface_;

public class Camera implements UsbInterface {
    @Override
    public void start() {
        System.out.println("相机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("相机开始工作");
    }
}
