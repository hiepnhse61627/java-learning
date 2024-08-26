package concurrency.collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TheProblem {

  public static void main(String[] args) {
//    var caplitalCities = new HashMap<String, String>();
    var caplitalCities = new ConcurrentHashMap<String, String>();
    caplitalCities.put("Oslo", "Norway");
    caplitalCities.put("Copenhagen", "Denmark");

    for (var key : caplitalCities.keySet()) {
      System.out.println(key + " is the capital of " + caplitalCities.get(key));
      caplitalCities.remove(key);
    }

    caplitalCities.put("Oslo", "Norway");
    caplitalCities.put("Copenhagen", "Denmark");

    System.out.println("=".repeat(50));

    System.out.println("Before: " + caplitalCities);
    for (var iter = caplitalCities.keySet().iterator(); iter.hasNext(); ) {
      var key = iter.next();
      System.out.println(key + " is the capital of " + caplitalCities.get(key));
      iter.remove();
    }
    System.out.println("After: " + caplitalCities);
  }
}
