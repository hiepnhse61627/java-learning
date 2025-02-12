package com.enthuware.javafund.exercises.chapter01v1;

import com.enthuware.javafund.exercises.chapter01v2.ClassB;

public class ClassA {

  public static int STATIC_FIELD = 5;

  public static void main(String[] args) {
    ClassB classB = new ClassB();

    System.out.println(classB.instanceField);

    int localVariable = 5;

    while (localVariable < 100) {
      localVariable++;
    }

    System.out.println(localVariable);
  }
}