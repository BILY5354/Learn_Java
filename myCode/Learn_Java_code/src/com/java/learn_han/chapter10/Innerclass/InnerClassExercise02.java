package com.java.learn_han.chapter10.Innerclass;

public class InnerClassExercise02 {

    
}

interface Bell {
    void ring();
}

class Cellphone {
    public void alarm_clock(Bell bell) {
        bell.ring();
    }
}
