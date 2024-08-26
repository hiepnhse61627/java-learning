package concurrency.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SynchronizedCollection {

  public static void main(String[] args) {
    var dogTypes = new ArrayList<String>();
    dogTypes.add("German Shepherd");
    dogTypes.add("Labrador");
    var synchronizedDogTypes = Collections.synchronizedList(dogTypes);

    // safe to use dogTypesSyn with multiple threads...
  }
}
