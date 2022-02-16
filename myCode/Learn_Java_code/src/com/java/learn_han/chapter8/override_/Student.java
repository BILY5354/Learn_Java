package com.java.learn_han.chapter8.override_;

public class Student extends Person {

    private int id;
    private double score;

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void Say() {
        super.Say();
        System.out.println( "也是学生"  + "\t" + getId() + "\t" + getScore());
    }
}
