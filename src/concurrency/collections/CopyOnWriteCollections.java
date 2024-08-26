package concurrency.collections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteCollections {

  public static void main(String[] args) {
    var names = new CopyOnWriteArrayList<String>();
    names.add("Ann");
    names.add("Brian");
    names.add("Carol");

    // API: "The snapshot style iterator method uses a reference
    //      to the state of the array at the point that the iterator was created.
    //      This array never changes during the lifetime of the iterator, so
    //      interference is impossible and the iterator is guaranteed not to throw
    //      ConcurrentModificationException.".
    for (var name : names) {
      System.out.println(name);
      System.out.println(names);
      names.add(name);
    }
    System.out.println(names);
    System.out.println("--------------------------------------");

    var uniqueNames = new CopyOnWriteArraySet<String>();
    uniqueNames.add("Ann");
    uniqueNames.add("Brian");
    uniqueNames.add("Carol");
    for (var name : uniqueNames) {
      System.out.println(name);
      System.out.println(uniqueNames);
      uniqueNames.add(name);
    }
    System.out.println(uniqueNames);
    System.out.println("Size is " + uniqueNames.size());
  }
}
