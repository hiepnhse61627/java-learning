package sequenced_collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;

public class SequencedCollections {

  public static void main(String[] args) {
    System.out.println("=============== SequencedCollection ===============");
    sequencedCollections();

    System.out.println("=============== SequencedSet ===============");
    sequencedSet();

    System.out.println("================ SequencedMap ===============");
    sequencedMap();
  }

  private static void sequencedCollections() {
    // A sequenced collection is a Collection whose elements have a defined encounter order.
    SequencedCollection<String> sequencedCollection = new ArrayList<>();

    sequencedCollection.addFirst("A"); // A
    sequencedCollection.addFirst("B"); // B, A
    sequencedCollection.addLast("C");  // B, A, C
    sequencedCollection.addLast("D");  // B, A, C, D
    System.out.println(sequencedCollection);
    System.out.println("getFirst(): " + sequencedCollection.getFirst()); // B
    System.out.println("getLast(): " + sequencedCollection.getLast());   // D
    System.out.println("removeFirst(): " + sequencedCollection.removeFirst()); // B - [A, C, D]
    System.out.println("removeLast(): " + sequencedCollection.removeLast());   // D - [A, C]
    System.out.println(sequencedCollection);

    // front to last
    System.out.println("Forwards..."); // A, C
    for (String s : sequencedCollection) {
      System.out.println(s);
    }

    // reverse order
    System.out.println("Backwards...");
    for (String s : sequencedCollection.reversed()) {
      System.out.println(s);
    }
  }

  private static void sequencedSet() {
    // A sequenced set is a SequencedCollection with no duplicate elements.
    SequencedSet<String> sequencedSet = new LinkedHashSet<>();
    sequencedSet.addFirst("A"); // A
    sequencedSet.addFirst("B"); // B, A
    sequencedSet.addLast("C");  // B, A, C
    sequencedSet.addLast("D");  // B, A, C, D

    System.out.println(sequencedSet);

    System.out.println("getFirst(): " + sequencedSet.getFirst()); // B
    System.out.println("getLast(): " + sequencedSet.getLast());   // D
    System.out.println("removeFirst(): " + sequencedSet.removeFirst()); // B - [A, C, D]
    System.out.println("removeLast(): " + sequencedSet.removeLast());   // D - [A, C]

    System.out.println(sequencedSet);

    // front to last
    System.out.println("Forwards..."); // A, C
    for (String s : sequencedSet) {
      System.out.println(s);
    }

    // reverse order
    System.out.println("Backwards...");
    for (String s : sequencedSet.reversed()) {
      System.out.println(s);
    }
  }

  private static void sequencedMap() {
    // A sequenced map is a Map whose entries have a defined encounter order
    SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();

    sequencedMap.putFirst(1, "Adam");      // 1=Adam
    sequencedMap.putFirst(2, "Brian");    // 2=Brian, 1=Adam
    sequencedMap.putLast(3, "Charlie");    // 2=Brian, 1=Adam, 3=Charlie
    sequencedMap.putLast(4, "David");      // 2=Brian, 1=Adam, 3=Charlie, 4=David

    System.out.println(sequencedMap);

    System.out.println("firstEntry() : " + sequencedMap.firstEntry());      // 2=Brian
    System.out.println("lastEntry() : " + sequencedMap.lastEntry());        // 4=David
    System.out.println("pollFirstEntry() : " + sequencedMap.pollFirstEntry());  // 2=Brian
    System.out.println("pollLastEntry() :" + sequencedMap.pollLastEntry());    // 4=David

    System.out.println(sequencedMap);      // {1=Adam, 3=Charlie}

    // front to last
    System.out.println("Forwards...");
    sequencedMap.forEach((k, v) -> System.out.println(k + ": " + v));

    // reverse order
    System.out.println("Backwards...");
    sequencedMap.reversed()
        .forEach((k, v) -> System.out.println(k + ": " + v));
  }
}
