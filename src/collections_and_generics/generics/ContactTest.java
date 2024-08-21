package collections_and_generics.generics;

import collections_and_generics.model.Contact;
import java.util.HashMap;
import java.util.Map;

public class ContactTest {

  private static Map<Contact, String> map = new HashMap<>();

  public static void main(String[] args) {
    var john = new Contact("john", 33);
    var peter = new Contact("peter", 34);
    System.out.println("john.hashCode() = " + john.hashCode());   // 58388
    System.out.println("peter.hashCode() = " + peter.hashCode()); // 58478
    map.put(john, "Irish");
    map.put(peter, "American");
    System.out.println(map.get(john));  // Irish
    System.out.println(map.get(peter)); // American

    var mary = new Contact("mary", 21);
    System.out.println("mary.hashCode() = " + mary.hashCode()); // 57320
    map.put(mary, "engineer");
    otherScope();
    System.out.println("After otherScope(): " + map.get(mary)); // accountant

    testJane();
    // HashMaps do not maintain order
    System.out.println(map);
    //{john, 33=Irish, mary, 21=accountant, jane, 21=nurse, peter, 34=American}
  }

  public static void otherScope() {
    var anotherMary = new Contact("mary", 21); // reconstruct "anotherMary"
    System.out.println("anotherMary.hashCode() = " + anotherMary.hashCode()); // 57320
    // Separate object used as a key to access the Map!
    System.out.println("In otherScope(): " + map.get(anotherMary)); // engineer

    // the next line overwrites mary with anotherMary as a key because:
    //    a) their hashcode are the same
    //    b) they are both equal according to equals()
    map.put(anotherMary, "accountant");
  }

  public static void testJane() {
    // "jane" will result in the same hashcode as "mary" or "anotherMary"
    // because their ages are the same and "mary" and "jane" each have
    // 4 letters. Thus, the hashing algorithm will find the same bucket.
    // The equals() method now however finds a different key because we are
    // searching based on "jane" within the bucket and not for "mary" as above.
    // As a result, when we do the "get", we get "nurse" and not "accountant".
    var jane = new Contact("jane", 21);
    System.out.println("jane.hashCode() = " + jane.hashCode()); // 57320
    map.put(jane, "nurse");
    System.out.println(map.get(jane)); // nurse
  }
}
