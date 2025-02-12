package ocp1721book.generics;

import java.util.List;

public class ListProcessor<E> {

  E data;

  public <E> ListProcessor(E e) {
    System.out.println("E is " + e);
  }

  public static <T> T processList(List<T> listOfT) {
    return listOfT == null || listOfT.isEmpty() ? null : listOfT.getFirst();
  }

  public static void main(String[] args) {

  }
}
