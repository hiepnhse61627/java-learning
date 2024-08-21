package collections_and_generics.generics;

import collections_and_generics.model.Dog;
import java.util.HashMap;

public class MutableFieldsTest {

  public static void main(String[] args) {
    // Dog has a hashCode() method
    var spot = new Dog("Spot", 10);
    var dogs = new HashMap<Dog, String>();

    dogs.put(spot, "Great Dane");
    System.out.println("spotInMap " + spot.hashCode()
        + " in map? : " + dogs.containsKey(spot)); // 419, true

    /*
    API: "Note: great care must be exercised if mutable objects are used as map keys.
    The behavior of a map is not specified if the value of an object is changed in a manner
    that affects equals comparisons while the object is a key in the map."
     */

    // change the object state (the dogs name); note that the dogs name IS USED in the
    // calculation of the hash value (and is used in equals() also).
    spot.setName("Rex");

    // assuming we have overridden hashCode(), it is false as the object state has changed
    // i.e. the hash code is re-calculated and is going to be different because the 'name' is
    // now different - this is dangerous!
    System.out.println("spotInMap " + spot.hashCode()
        + " in map? : " + dogs.containsKey(spot)); // 418, false

    spot.setName("Spot");
    System.out.println("spot value: " + dogs.get(spot));
  }
}
