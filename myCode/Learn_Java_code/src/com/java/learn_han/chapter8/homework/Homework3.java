package com.java.learn_han.chapter8.homework;

public class Homework3 {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("tom", 20, "普通老师", 1000);
        JiangShi jiangShi = new JiangShi("ben", 30, "讲师", 1000);
        PeProfessor peProfessor =new PeProfessor("jay", 40, "副教授", 1000);
        Professor professor = new Professor("key", 50, "教授", 1000);

        teacher.introduce();
        jiangShi.introduce();
        peProfessor.introduce();
        professor.introduce();
    }
}

class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public void introduce() {
        System.out.print("name = " + name);
        System.out.print("\tage = " + age);
        System.out.print("\tpost = " + post);
        System.out.println("\tsalary = " + salary);
    }

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Professor extends Teacher{

    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.print("name = " + getName());
        System.out.print("\tage = " + getAge());
        System.out.print("\tpost = " + getPost());
        System.out.println("\t教授工资（1.3）salary = " + getSalary() * 1.3);
    }
}

class PeProfessor extends Teacher {

    public PeProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.print("name = " + getName());
        System.out.print("\tage = " + getAge());
        System.out.print("\tpost = " + getPost());
        System.out.println("\t副教授工资（1.2）salary = " + getSalary() * 1.2);
    }
}

class JiangShi extends Teacher {

    public JiangShi(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.print("name = " + getName());
        System.out.print("\tage = " + getAge());
        System.out.print("\tpost = " + getPost());
        System.out.println("\t讲师工资（1.1）salary = " + getSalary() * 1.1);
    }
}
