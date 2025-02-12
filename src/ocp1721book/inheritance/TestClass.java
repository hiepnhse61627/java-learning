package ocp1721book.inheritance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

abstract class Sofa {

  private final void recline() {
    System.out.println("recline");
  }

  static final int getWidth() {
    return 36;
  }
}

class IronSofa extends Sofa {
//  static int getWidth() {
//    return 60;
//  }
}

class Person {

  String name;

  Person(String name) {
    System.out.println("In Person constructor");
    this.name = name;
  }
}

class Employee extends Person {

  String empId;

  Employee() {
    this("dummy", "000");
    System.out.println("In Employee() constructor");
  }

  Employee(String name, String empId) {
    super(name);
    System.out.println("In Employee(name, empId) constructor");
  }
}

class Manager extends Employee {

  String grade;

  Manager(String grade) {
    System.out.println("In Manager(grade) constructor");
    this.grade = grade;
  }
}

//class Fruit {
//
//  void print() {
//    System.out.println("Fruit");
//  }
//}
//
//class Apple extends Mango {
//
//  @Override
//  void print() {
//    System.out.println("Apple");
//  }
//}
//
//class Mango extends Fruit {
//
//  @Override
//  void print() {
//    System.out.println("Mango");
//  }
//}

class Fruit {
  public void mash(Collection fruit) {
    System.out.println("In Fruit's mash(Collection)");
  }
}

class Apple extends Fruit {
  public void mash(Collection apples) {
    System.out.println("In Apple's mash(Collection)");
  }

  public void mash(List apples) {
    System.out.println("In Apple's mash(List)");
  }

  public void mash(Apple apple) {
    System.out.println("In Apple's mash(Apple)");
  }
}

public class TestClass {

  public static void main(String[] args) {
    Collection c = new ArrayList();
    Fruit f = new Fruit();
    Fruit fa = new Apple();
    Apple a = new Apple();

    f.mash(c);
    fa.mash(c);
    a.mash(c);
//    f.mash(a);
//    fa.mash(a);
    List<Apple> la = new ArrayList<Apple>();
    Collection<Apple> ca = la;

    a.mash(la);
    a.mash(ca);
  }
}
