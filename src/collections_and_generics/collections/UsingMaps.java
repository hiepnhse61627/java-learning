package collections_and_generics.collections;

import java.util.TreeMap;

public class UsingMaps {

  public static void main(String[] args) {
    var treeMap = new TreeMap<String, Integer>(); // sorted by keys
    treeMap.put("John", 18);
    treeMap.put("Mary", 21);
    treeMap.put("Chris", 33);

    System.out.println(treeMap.containsKey("John")); // true
    System.out.println(treeMap.containsValue(18));   // true
    System.out.println(treeMap.isEmpty());           // false
    System.out.println(treeMap.get("John"));         // 18

    for (var key : treeMap.keySet()) {
      System.out.print(key);// Chris, John, Mary
      System.out.print(" ");
    }
    System.out.println();

    for (var value : treeMap.values()) { // sort is by keys
      System.out.print(value); // 33, 18, 21
      System.out.print(" ");
    }
    System.out.println();

    System.out.println(treeMap.containsValue("Paul")); // false
    System.out.println(treeMap.containsValue(21));     // true
    System.out.println(treeMap.size());                // 3
    treeMap.clear();
    System.out.println(treeMap.size());                // 0

    // forEach()
    treeMap.put("John", 18);
    treeMap.put("Mary", 21);
    treeMap.put("Chris", 33);
    // Chris maps to 33
    // John maps to 18
    // Mary maps to 21
    //   forEach(BiConsumer)
    //     BiConsumer<T,U>     void accept(T t, U u)
    treeMap.forEach((key, value) -> System.out.println(key + " maps to " + value));

    // Set<Map.Entry<K,​V> entrySet() - Map.Entry encapsulates a key-value pair.
    // go from a Map to a Set (an official Collection)
    // Chris -> 33
    // John  -> 18
    // Mary  -> 21
    treeMap.entrySet().forEach(entry //    forEach(Consumer)
        -> System.out.println(entry.getKey() + " maps to " + entry.getValue()));

    var keys = treeMap.keySet();    // [Chris, John, Mary]
    // putIfAbsent()
    treeMap.put("Mike", null);          // {Chris=33, John=18, Mary=21, Mike=null}
    treeMap.putIfAbsent("Chris", 99);   // {Chris=33, John=18, Mary=21, Mike=null}
    treeMap.putIfAbsent("Mike", 55);    // {Chris=33, John=18, Mary=21, Mike=55}
    treeMap.putIfAbsent("Luke", 31);    // {Chris=33, John=18, Luke=31, Mary=21, Mike=55}

    // replace() and replaceAll
    var original = treeMap.replace("Chris", 81);
    System.out.println("Original value: " + original);
    System.out.println(treeMap);        // {Chris=81, John=18, Luke=31, Mary=21, Mike=55}
    // BiFunction<T, U, R>
    //   R apply(T t, U u) - 2 inputs and an output; all of which can be different types
    // replaceAll(BiFunction<K, V, V> fn) - note the return type is of type V also
    treeMap.replaceAll((name, age) -> name.length());
    System.out.println(treeMap);        // {Chris=5, John=4, Luke=4, Mary=4, Mike=4}

    // remove()
    treeMap.remove("Mike");        // {Chris=5, John=4, Luke=4, Mary=4}
  }
}
