package quiz_questions.generics_and_collections;

import java.util.TreeSet;

public class OCPJPv821471 {

  public static void main(String[] args) {
    TreeSet<Integer> set = new TreeSet<>();
    TreeSet<Integer> subset = new TreeSet<>();

    for (int i = 324; i <= 328; i++) {
      set.add(i);
    }

    subset = (TreeSet<Integer>) set.subSet(326, true, 328, true);
    subset.add(325); // key out of range
    System.out.println(set + " " + subset);
  }
}
