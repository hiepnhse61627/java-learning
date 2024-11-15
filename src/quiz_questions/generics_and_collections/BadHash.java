package quiz_questions.generics_and_collections;

import java.util.HashSet;
import java.util.Random;

class Person {

  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Person person = (Person) obj;
    return age == person.age && name.equals(person.name);
  }

  // Incorrect hashCode implementation: it always returns a constant
  @Override
  public int hashCode() {
    Random random = new Random();
    return random.nextInt(); // BAD hashCode implementation
  }

  @Override
  public String toString() {
    return name + " (" + age + ")";
  }
}

public class BadHash {

  public static void main(String[] args) {
    HashSet<Person> people = new HashSet<>();

    Person p1 = new Person("Alice", 30);
    Person p2 = new Person("Alice", 30);

    people.add(p1);
    people.add(p2);

    System.out.println(p1.hashCode());
    System.out.println(p2.hashCode());

    System.out.println("HashSet size: " + people.size()); // Expected: 1
    System.out.println("HashSet contents: " + people);    // Expected: [Alice (30)]
  }
}
