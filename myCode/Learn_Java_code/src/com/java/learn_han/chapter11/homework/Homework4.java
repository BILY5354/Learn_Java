package com.java.learn_han.chapter11.homework;

/**
 * @author CDUY
 * @version 1.0
 */
public class Homework4 {
    public static void main(String[] args) {
        new CellPhone(){}.testWork(new pC() {
            @Override
            public double work(double n1, double n2) {
                return n1+n2;
            }
        },10, 8);

        oldCellPhone oldCellPhone = new oldCellPhone();
        System.out.println(oldCellPhone.work(12,6));
    }
}

interface pC {
    double work(double n1, double n2);
}

class oldCellPhone implements pC{

    @Override
    public double work(double n1, double n2) {
        return n1 + n2;
    }
}

class CellPhone {
    public void testWork(pC pc, double n1, double n2) {
       double result = pc.work(n1, n2);
        System.out.println(result);
    }
}


