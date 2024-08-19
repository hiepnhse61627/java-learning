package collections_and_generics.collections;

import java.util.ArrayList;
import java.util.Collection;

public class CommonCollectionMethods {

  public static void main(String[] args) {
    // Lists allow duplicates
    Collection<String> collection = new ArrayList<>();

    // asList() returns an unmodifiable collection
    //  => add() throws an UnsupportedOperationException
//    Collection<String> unmofiableCollection = Arrays.asList("Lucy", "April", "Lucy");//immutable

    collection.add("Lucy");
    collection.add("April");
    collection.add("Lucy");

    System.out.println(collection);                 // [Lucy, April, Lucy]
    System.out.println(collection.remove("Lucy"));  // true
    System.out.println(collection);                 // [April, Lucy]
    System.out.println(collection.isEmpty());       // false
    System.out.println(collection.size());          // 2
    System.out.println(collection.contains("John"));// false
    System.out.println(collection.contains("Lucy"));// true

    // removeIf(Predicate) and Predicate == boolean test(T t)
    System.out.println(collection.removeIf(s -> s.startsWith("A")));// true
    collection.forEach(name -> System.out.println(name));    // [Lucy]
    collection.clear();
    collection.forEach(System.out::println); // nothing output
  }
}
