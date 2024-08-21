package collections_and_generics.generics;

import collections_and_generics.model.Dog;
import java.util.ArrayList;
import java.util.List;

public class PreGenerics {

  public static void main(String[] args) {
    // A raw collection can hold any type of Object (except a primitive)
    var myList = new ArrayList(); // can't enforce a type
    myList.add("Fred");           // will hold Strings
    myList.add(new Dog());        // and Dogs
    myList.add(43);               // and Integers (autoboxing)

    // As everything is treated as Object, when you are getting something out of the collection,
    // all you have were object's - therefore a cast was required to get your String back.
    var s = (String) myList.get(0);  // cast required else compiler error
    // and as we could not guarantee that what was coming out
    // was really a String (as we were allowed to put anything in),
    // this cast could fail at runtime
//    var s1 = (String) myList.get(1); // ClassCastException at runtime

    // Generics takes care of both ends (putting in and getting out)
    // by enforcing the type of your collections.
    // Note: generic syntax means putting the type in angle brackets
    var myList2 = new ArrayList<String>();
    myList2.add("Fred");             // will hold Strings
//    myList2.add(new Dog());          // compiler error
    // Because what is going IN is guaranteed, what is coming OUT is
    // also guaranteed => no need for the cast
    String s2 = myList2.get(0); // cast no longer required

    var myList3 = new ArrayList<String>();
    myList3.add("Fred");

    var myList4 = takeListOfStrings(myList3);

    System.out.println(myList3);
    System.out.println(myList4);
  }

  // generics can be passed down to and returned from methods
  public static List<String> takeListOfStrings(List<String> strings) {
    strings.add("Tom");
    return strings;
  }
}




