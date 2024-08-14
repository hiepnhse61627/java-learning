package streams;

import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExamples {

  public static void main(String[] args) {
    System.out.println("=".repeat(20) + " doJoining " + "=".repeat(20));
    doJoining();

    System.out.println("=".repeat(20) + " doAveragingInt " + "=".repeat(20));
    doAveragingInt();

    System.out.println("=".repeat(20) + " doCollectorToMap1 " + "=".repeat(20));
    doCollectorToMap1();

    System.out.println("=".repeat(20) + " doCollectorToMap2 " + "=".repeat(20));
    doCollectorToMap2();

    System.out.println("=".repeat(20) + " doCollectorToMap3 " + "=".repeat(20));
    doCollectorToMap3();

    System.out.println("=".repeat(20) + " doGroupingBy1 " + "=".repeat(20));
    doGroupingBy1();

    System.out.println("=".repeat(20) + " doGroupingBy2 " + "=".repeat(20));
    doGroupingBy2();

    System.out.println("=".repeat(20) + " doGroupingBy3 " + "=".repeat(20));
    doGroupingBy3();

    System.out.println("=".repeat(20) + " doPartitioning1 " + "=".repeat(20));
    doPartitioning1();

    System.out.println("=".repeat(20) + " doPartitioning2 " + "=".repeat(20));
    doPartitioning2();

    System.out.println("=".repeat(20) + " doPartitioning3 " + "=".repeat(20));
    doPartitioning3();

    System.out.println("=".repeat(20) + " doPartitioning4 " + "=".repeat(20));
    doPartitioning4();
  }

  public static void doJoining() {
    var myName = Stream.of("Hiep", "Nguyen")
        .collect(Collectors.joining(" - "));
    System.out.println(myName);
  }

  public static void doAveragingInt() {
    var avg = Stream.of("Hiep", "Nguyen")
        // averagingInt(ToIntFunction) functional method is:
        //      int applyAsInt(T value);
        .collect(Collectors.averagingInt(String::length));
    System.out.println(avg);
  }

  public static void doCollectorToMap1() {
    // We want a map: dessert name -> number of characters in dessert name
    // Output:
    //   {biscuits=8, cake=4, apple tart=10}
    var map = Stream.of("biscuits", "cake", "apple tart")
        .collect(
            Collectors.toMap(
                s -> s,        // Function for the key
                String::length // Function for the value
            ));
    System.out.println(map);
  }

  public static void doCollectorToMap2() {
    // We want a map: number of characters in dessert name -> dessert name
    // However, 2 of the desserts have the same length (cake and tart) and as
    // length is our key, and we can't have duplicate keys, this leads to an
    // exception as Java does not know what to do...
    //    IllegalStateException: Duplicate key 4 (attempted merging values cake and tart)
    // To get around this, we can supply a merge function, whereby we append the
    // colliding keys values together.
    var map = Stream.of("biscuits", "cake", "tart")
        .collect(
            Collectors.toMap(
                String::length,            // key is the length
                s -> s,                    // value is the String
                (s1, s2) -> s1 + "/" + s2  // Merge function - what to do if we have duplicate keys
                // => append the values
            )
        );
    System.out.println(map);
  }

  public static void doCollectorToMap3() {
    // The maps returned are HashMaps but this is not guaranteed. What if we wanted
    // a TreeMap implementation so our keys would be sorted. The last argument
    // caters for this.
    var map = Stream.of("biscuits", "cake", "apple tart", "cake")
        .collect(
            Collectors.toMap(
                s -> s,         // key is the String
                String::length, // value is the length of the String
                Integer::sum,   // what to do if we have duplicated keys => add the *values*
                TreeMap::new    // TreeMap::new works
            )
        );
    System.out.println(map);
    System.out.println(map.getClass());
  }

  public static void doGroupingBy1() {
    var map = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan")
        .collect(
            // passing in a Function that determines the
            // key in the Map
            Collectors.groupingBy(String::length) // s -> s.length()
        );
    System.out.println(map);
  }

  public static void doGroupingBy2() {
    var map = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan")
        .collect(
            Collectors.groupingBy(
                String::length,    // s -> s.length()
                Collectors.toSet() // what to do with the values
            )
        );
    System.out.println(map);
    System.out.println(map.getClass());
  }

  public static void doGroupingBy3() {
    var map = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan")
        .collect(
            Collectors.groupingBy(
                String::length,
                TreeMap::new,       // map type Supplier
                Collectors.toList() // downstream collector
            )
        );
    System.out.println(map);
    System.out.println(map.getClass());
  }

  public static void doPartitioning1() {
    var map = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter")
        .collect(
            // pass in a Predicate
            Collectors.partitioningBy(s -> s.startsWith("T"))
        );
    System.out.println(map);
  }

  public static void doPartitioning2() {
    var map = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter")
        .collect(
            // pass in a Predicate
            Collectors.partitioningBy(s -> s.length() > 4)
        );
    System.out.println(map);
  }

  public static void doPartitioning3() {
    var map = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter")
        .collect(
            // pass in a Predicate
            Collectors.partitioningBy(s -> s.length() > 10)
        );
    System.out.println(map);
  }

  public static void doPartitioning4() {
    var map = Stream.of("Alan", "Teresa", "Mike", "Alan", "Peter")
        .collect(
            // pass in a Predicate
            Collectors.partitioningBy(
                s -> s.length() > 4,
                Collectors.toSet()
            )
        );
    System.out.println(map);
  }
}
