package ocp1721book.generics;

import java.util.ArrayList;
import java.util.List;

public class TestClassArrayList {

  public static void main(String[] args) {
//    var al = new ArrayList<Integer>();
//    al.add(1).add(2);
//    System.out.println(al);

//    ArrayList<String> al = new ArrayList<>();
//    if (al.add("a")) {
//      if (al.contains("a")) {
//        al.add(al.indexOf("a"), "b");
//      }
//    }
//    System.out.println(al);

    ArrayList<String> al = new ArrayList<>();
    al.add("a");
    al.add("b");
    al.add(al.size(), "x");
    System.out.println(al);

    var list1 = new ArrayList<String>();
    var list2 = new ArrayList<String>();
    list1.add("a");
    list1.add("b");
    list2.add("b");
    list2.add("c");
    list2.add("d");
    list1.addAll(list2);
    list1.remove("b");
    System.out.println(list1);

    List<Number> list = new ArrayList<>();
    list.add(5);

    System.out.println(averageN(list));
  }

  static double averageN(List<Number> list) {
    double sum = 0.0;
    list.add(10);
    for (Number n : list) {
      sum += n.doubleValue();
    }
    return sum / list.size();
  }

  static <E extends Number> double averageKxN(List<E> list) {
    double sum = 0.0;
//    list.add(10); // reject
    for (Number n : list) {
      sum += n.doubleValue();
    }
    return sum / list.size();
  }
}
