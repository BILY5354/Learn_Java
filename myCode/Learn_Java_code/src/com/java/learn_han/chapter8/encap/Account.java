package com.java.learn_han.chapter8.encap;

public class Account {
    String name;
    double salary;
    String password;

    public Account() {

    }

    public Account(String name, double salary, String password) {
        setName(name);
        setSalary(salary);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 20) {
            System.out.println("没钱啦自动充20");
            this.salary = 20;
        } else {
            this.salary = salary;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        } else {
            System.out.println("密码长度不为6，自动重置为：111111");
            this.password = "111111";
        }
    }

    public String showInfo() {
        return "Name: " + name + " Salary: " + salary + "Password: " + password;
    }
}
