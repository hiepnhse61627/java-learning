package com.enthuware.javafund.exercises.chapter02;

public class Person {

  int id; // 0
  String name; // null
  java.util.Date dob; // null
  boolean VIP; // false

  public static void main(String[] args) {
    Person p1 = new Person();
    Person p2 = p1;

    int id = p2.id;

    System.out.println(p1.id);
    System.out.println(id);
    System.out.println(p1.dob);
    System.out.println(p2.VIP);
    p1.name = args[0];

    System.out.println(p1.name);
  }

  public String getName() {
    return name;
  }
}
