package com.java.learn_han.chapter10.interface_;

public class LocalInnerClass {//
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        System.out.println("Outer02.this hashcode=" + outer02);
        outer02.m1();
    }
}


class Outer02 {//外部类
    private int n1 = 100;
    private void m2() {
        System.out.println("Outer02 m2()");
    }
    public void m1() {

        final class Inner02 {
            private int n1 = 800;
            public void f1() {

                System.out.println("内部类的 n1=" + n1);//6. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，
                // 如果想访问外部类的成员，使用 外部类名.this.成员）去访问
                System.out.print("外部类的 n1=" + Outer02.this.n1);//Outer02.this 本质就是外部类的对象, 即哪个对象调用了m1, Outer02.this就是哪个对象
                System.out.println("  Outer02.this hashcode=" + Outer02.this);
                m2();
            }
        }
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}