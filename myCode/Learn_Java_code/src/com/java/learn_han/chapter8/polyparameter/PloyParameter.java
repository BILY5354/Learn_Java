package com.java.learn_han.chapter8.polyparameter;

public class PloyParameter {
    public static void main(String[] args) {

        Worker tom = new Worker("tom", 2500);
        Manager milan = new Manager("milan", 5000, 100000);
        PloyParameter ployParameter = new PloyParameter();
        ployParameter.showEmpAnnual(tom);
        ployParameter.showEmpAnnual(milan);
        ployParameter.testWork(tom);
        ployParameter.testWork(milan);
    }

    //实现获取对热河员工对象的年工资，并在main方法中调用该方法
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());
    }
    //添加一个方法，如果普通员工调用work，经理调用manage
    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker) e).work();//向下转型操作
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        } else {
            System.out.println("类型有误, 请自己检查...");
        }
    }
}
