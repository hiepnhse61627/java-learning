package collections_and_generics;

import collections_and_generics.model.Cat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingCatsMultipleFields {

  public static void main(String[] args) {
    var cats = new ArrayList<Cat>();
    cats.add(new Cat("Trixy", 5));
    cats.add(new Cat("Bella", 7));
    cats.add(new Cat("Bella", 2)); // second Bella

    var comparator = Comparator
        .comparing(Cat::getName)
        .thenComparing(Cat::getAge);

    Collections.sort(cats, comparator);
    System.out.println(cats); // [Cat{name=Bella, age=2}, Cat{name=Bella, age=7}, Cat{name=Trixy, age=5}]
  }
}
