package com.java.learn_han.chapter8.extend_;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "银角大王";
        pupil.age = 11;
        pupil.testing();
        pupil.setScore(50);
        pupil.showInfo();

        System.out.println("=========================");
        Graduate graduate = new Graduate();
        graduate.name = "金角大王";
        graduate.age = 21;
        graduate.testing();
        graduate.setScore(90);
        graduate.showInfo();
    }

}
