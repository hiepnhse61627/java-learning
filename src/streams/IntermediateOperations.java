package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

class Person {

  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
  }

  public int getAge() {
    return age;
  }
}

public class IntermediateOperations {

  public static void main(String[] args) {
    System.out.println("=".repeat(30) + " doFilter " + "=".repeat(30));
    doFilter();

    System.out.println("=".repeat(30) + " doDistinct " + "=".repeat(30));
    doDistinct();

    System.out.println("=".repeat(30) + " doLimit " + "=".repeat(30));
    doLimit();

    System.out.println("=".repeat(30) + " doMap " + "=".repeat(30));
    doMap();

    System.out.println("=".repeat(30) + " doFlatMap " + "=".repeat(30));
    doFlatMap();

    System.out.println("=".repeat(30) + " doSortedFromBook " + "=".repeat(30));
    doSortedFromBook();

    System.out.println("=".repeat(30) + " doSorted2 " + "=".repeat(30));
    doSorted2();

    System.out.println("=".repeat(30) + " doSortedOther " + "=".repeat(30));
    doSortedOther();
  }

  public static void doSortedOther() {
    // Stream<T> sorted()
    // Stream<T> sorted(Comparator<T> comparator)
    // Output:
    //  0.Tim 1.Tim 0.Jim 1.Jim 0.Peter 0.Ann 1.Ann 0.Mary 2.Ann 3.Ann 2.Jim 3.Jim
    Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
        .peek(name -> System.out.print(" 0." + name))     // Tim, Jim, Peter, Ann, Mary
        .filter(name -> name.length() == 3)
        .peek(name -> System.out.print(" 1." + name))     // Tim, Jim, Ann
        .sorted()                                         // Tim, Jim, Ann (stored)
        .peek(name -> System.out.print(" 2." + name))     // Ann, Jim
        .limit(2)
        .forEach(name -> System.out.print(" 3." + name)); // Ann, Jim
  }

  public static void doSorted2() {
    // Stream<T> sorted(Comparator<T> comparator)
    // Output:
    //   Person{name=John, age=23}Person{name=Mary, age=25}
    var john = new Person("John", 23);
    var mary = new Person("Mary", 25);
    Stream.of(john, mary)
        // .sorted(Comparator.comparing(Person::getAge)
        .sorted(Comparator.comparing(p -> p.getAge()))
        .forEach(System.out::println);
  }


  public static void doSortedFromBook() {
    // Stream<T> sorted()
    // Stream<T> sorted(Comparator<T> comparator)
    // Output:
    //  0.Toby 1.Toby - sorted() can't sort yet
    //                  needs all the data, holds Toby
    //  0.Anna 1.Anna - sorted() can't sort yet, holds Anna
    //  0.Leroy       - filtered out
    //  0.Alex 1.Alex - sorted() can't sort yet, holds Alex
    //                - Java tells sorted() - "its time to sort"
    //  2.Alex 3.Alex - limit() passes on Alex, Alex is output
    //  2.Anna 3.Anna - limit() passes on Anna and lets Java know
    //                  that's 2 of 2; Java lets forEach print Anna
    //                  and then stops the pipeline
    // Note: Toby is not output.
    Stream.of("Toby", "Anna", "Leroy", "Alex").peek(s -> System.out.print(" 0." + s))
        .filter(s -> s.length() == 4)
        .peek(s -> System.out.print(" 1." + s))
        .sorted()
        .peek(s -> System.out.print(" 2." + s))
        .limit(2)
        .forEach(s -> System.out.print(" 3." + s));

    System.out.println();
  }

  public static void doFlatMap() {
    var list01 = Arrays.asList("Tra", "My");
    var list02 = Arrays.asList("Hiep", "Nguyen");
    var streamOfList = Stream.of(list01, list02);

    // flatMap(Function(T, R)) IN:T OUT:R
    //  flatMap(List<String>, Stream<String>)
    streamOfList.flatMap(Collection::stream) // list -> list.stream()
        .forEach(System.out::print);

    System.out.println();
  }

  public static void doMap() {
    // <R> Stream<R> map(Function<T,R> mapper)
    //     Function's functional method: R apply(T t);
    Stream.of("book", "pen", "ruler")
        .map(String::length) // s -> s.length()
        .forEach(System.out::println);
  }

  public static void doLimit() {
    // Stream<T> limit(long maxSize)
    // limit is a short-circuiting stateful intermediate operation.
    // Lazy evaluation - 66, 77, 88 and 99 are not streamed as they are not needed
    // (limit of 2 i.e. 44 and 55).
    // Output:
    //  A - 11 A - 22 A - 33 A - 44 B - 44 C - 44 A - 55 B - 55 C - 55
    Stream.of(11, 22, 33, 44, 55, 66, 77, 88, 99)
        .peek(n -> System.out.println(" A - " + n))
        .filter(n -> n > 40)
        .peek(n -> System.out.println(" B - " + n))
        .limit(2)
        .forEach(n -> System.out.println(" C - " + n));
  }

  public static void doDistinct() {
    // Stream<T> distinct()
    // distinct() is a stateful intermediate operation
    // Output: 1.eagle 2.eagle 1.eagle 1.EAGLE 2.EAGLE
    Stream.of("eagle", "eagle", "EAGLE")
        .peek(s -> System.out.println(" 1." + s))
        .distinct()
        .forEach(s -> System.out.println(" 2." + s));
  }

  public static void doFilter() {
    // Stream<T> filter(Predicate)
    // The filter() method returns a Stream with the elements that MATCH the given predicate.
    Stream.of("Hiep", "Nguyen", "Tra My")
        .filter(name -> name.length() > 4)
        .forEach(System.out::println);
  }
}
