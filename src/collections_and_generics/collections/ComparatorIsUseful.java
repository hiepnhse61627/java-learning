package collections_and_generics.collections;

import collections_and_generics.model.Boss;
import collections_and_generics.model.Worker;
import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorIsUseful {

  public static void main(String[] args) {
    var bosses = new TreeSet<Boss>();
    bosses.add(new Boss(20));
    bosses.add(new Boss(10));
    bosses.add(new Boss(15));
    System.out.println(bosses); // [Boss{id=10}, Boss{id=15}, Boss{id=20}]

//    var workers = new TreeSet<Worker>(); // ClassCastException: class Worker cannot be cast to Comparable
//    var workers = new TreeSet<>(Comparator.comparingInt(Worker::getId));
//    var workers = new TreeSet<>(Comparator.comparing(worker -> worker.getId()));
    var workers = new TreeSet<>(Comparator.comparing(Worker::getId)); // unbound meth reference

    workers.add(new Worker(30));
    workers.add(new Worker(20));
    workers.add(new Worker(10));
    workers.add(new Worker(21));
    System.out.println(workers); // [Worker{id=10}, Worker{id=20}, Worker{id=21}, Worker{id=30}]
  }
}
