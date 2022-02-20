package com.java.learn_han.chapter8.polyarr_;

public class PloyArray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("LiHua", 18, 100);
        persons[2] = new Student("ZhangShan", 14, 60);
        persons[3] = new Teacher("Li", 56, 10000);
        persons[4] = new Teacher("Hai", 28, 2000);

        //循环遍历多态数组，调用say
        for (int i = 0; i < persons.length; i++) {
            // persons[i] 编译类型是 Person， 运行类型根据实际情况JVM判断
            System.out.println(persons[i].say());
            if (persons[i] instanceof Student) {//判断person[i] 的运行类型是不是Student
                Student student = (Student) persons[i];//向下转型
                student.study();
            }
            else if (persons[i] instanceof Teacher) {//判断person[i] 的运行类型是不是Student
                ((Teacher)persons[i]).teach();
            } 
        }

    }
}
