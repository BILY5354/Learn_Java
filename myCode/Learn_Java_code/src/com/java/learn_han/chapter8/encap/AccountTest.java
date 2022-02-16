package com.java.learn_han.chapter8.encap;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("CDUY");
        account.setSalary(10);
        account.setPassword("12346");

        System.out.println(account.showInfo());
    }
}
