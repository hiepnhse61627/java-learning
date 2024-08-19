package collections_and_generics.collections;

import collections_and_generics.model.Dog;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDogs {

  public static void main(String[] args) {
    System.out.println("=".repeat(30) + " comparableArray " + "=".repeat(30));
    comparableArray(new Dog[]{new Dog("Spot", 2), new Dog("Rover", 7)});// just-in-time array

    System.out.println("=".repeat(30) + " comparableList " + "=".repeat(30));
    comparableList(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));

    System.out.println("=".repeat(30) + " comparatorArray " + "=".repeat(30));
    comparatorArray(new Dog[]{new Dog("Spot", 2), new Dog("Rover", 7)});

    System.out.println("=".repeat(30) + " comparatorList " + "=".repeat(30));
    comparatorList(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));
  }

  public static void comparableArray(Dog[] dogs) {
    Arrays.sort(dogs);
    System.out.println(Arrays.toString(dogs)); // [Dog{name=Rover, age=7}, Dog{name=Spot, age=2}]
  }

  public static void comparableList(List<Dog> dogs) {
    Collections.sort(dogs);
    System.out.println(dogs); // [Dog{name=Rover, age=7}, Dog{name=Spot, age=2}]
  }

  public static void comparatorArray(Dog[] dogs) {
    // sorts ascending by age
    var byAge = Comparator.comparing(Dog::getAge);
    Arrays.sort(dogs, byAge);
    System.out.println(Arrays.toString(dogs)); // [Dog{name=Spot, age=2}, Dog{name=Rover, age=7}]

    var byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
    Arrays.sort(dogs, byAgeReversed);
    System.out.println(Arrays.toString(dogs)); // [Dog{name=Rover, age=7}, Dog{name=Spot, age=2}]
  }

  public static void comparatorList(List<Dog> dogs) {
    // sorts ascending by age
    var byAge = Comparator.comparing(Dog::getAge);
    Collections.sort(dogs, byAge);
    System.out.println(dogs); // [Dog{name=Spot, age=2}, Dog{name=Rover, age=7}]

    var byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
    Collections.sort(dogs, byAgeReversed);
    System.out.println(dogs);
  }
}
