package concurrency.collections;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipListCollections {

  public static void main(String[] args) {
    var countries = new ConcurrentSkipListSet<String>(); // TreeSet concurrent version
    countries.add("Germany");
    countries.add("Canada");
    countries.add("Australia");

    // natural order for String is alphabetic
    for(String country:countries){
      System.out.println(country);
    }

    var map = new ConcurrentSkipListMap<String, Integer>(); // TreeMap concurrent version
    map.put("Jack", 12);
    map.put("Zack", 15);
    map.put("Anna", 22);

    // ordered by keys
    for(String key:map.keySet()){
      System.out.println(key + " -> " + map.get(key));
    }
  }
}
