package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperators {

  public static void main(String[] args) {
    System.out.println("=".repeat(20) + " doCount " + "=".repeat(20));
    doCount();

    System.out.println("=".repeat(20) + " doMinAndMax " + "=".repeat(20));
    doMinAndMax();

    System.out.println("=".repeat(20) + " doMatches " + "=".repeat(20));
    doMatches();

    System.out.println("=".repeat(20) + " doFindAnyFindFirst " + "=".repeat(20));
    doFindAnyFindFirst();

    System.out.println("=".repeat(20) + " doForEach " + "=".repeat(20));
    doForEach();

    System.out.println("=".repeat(20) + " doReduce1 " + "=".repeat(20));
    doReduce1();

    System.out.println("=".repeat(20) + " doReduce2 " + "=".repeat(20));
    doReduce2();

    System.out.println("=".repeat(20) + " doReduce3 " + "=".repeat(20));
    doReduce3();

    System.out.println("=".repeat(20) + " doCollect1 " + "=".repeat(20));
    doCollect1();
  }

  public static void doCount() {
    var count = Stream.of("Dog", "Cat", "Cow").count();
    System.out.println(count);
  }

  public static void doMinAndMax() {
    // Optional<T> min(Comparator)
    // Optional<T> max(Comparator)
    // Optional introduce in Java 8 to replace 'null'. If the stream is
    // empty then the Optional will be empty (and we won't have to
    // deal with null).
    var min = Stream.of("deer", "horse", "pig").min((s1, s2) -> s1.length() - s2.length());
    min.ifPresent(System.out::println);

    var max = Stream.of(4, 6, 2, 12, 9).max(Comparator.comparingInt(i -> i));
    max.ifPresent(System.out::println);
  }

  public static void doMatches() {
    // boolean anyMatch(Predicate)
    // boolean allMatch(Predicate)
    // boolean noneMatch(Predicate)
    var names = Arrays.asList("Alan", "Brian", "Colin");
    var predicate = (Predicate<String>) name -> name.startsWith("A");
    System.out.println(names.stream().anyMatch(predicate));
    System.out.println(names.stream().allMatch(predicate));
    System.out.println(names.stream().noneMatch(predicate));
  }

  public static void doFindAnyFindFirst() {
    // Optional<T> findAny()
    // Optional<T> findFirst()
    // These are terminal operations but not reductions
    // as they sometimes return without processing all
    // the elements in the stream. Reductions reduce the
    // entire stream into one value.
    var any = Stream.of("John", "Paul").findAny();
    any.ifPresent(System.out::println);// John (usually)

    var first = Stream.of("John", "Paul").findFirst();
    first.ifPresent(System.out::println);// John
  }

  public static void doForEach() {
    // void forEach(Consumer)
    // As there is no return value, forEach() is not a reduction.
    // As the return type is 'void', if you want something to
    // happen, it has to happen inside the Consumer (side-effect).
    Stream<String> names = Stream.of("Cathy", "Pauline", "Zoe");
    names.forEach(System.out::println);//CathyPaulineZoe

    // Notes: forEach is also a method in the Collection interface.
    //        Streams cannot be the source of a for-each loop
    //        because streams do not implement the Iterable interface.
    Stream<Integer> s = Stream.of(1);
    //       for(Integer i : s){}// error: required array or Iterable
  }

  public static void doReduce1() {
    // The reduce() method combines a stream into a single object.
    // It is a reduction, which means it processes all elements.
    // The most common way of doing a reduction is to start with
    // an initial value and keep merging it with the next value.

    // T reduce(T identity, BinaryOperator<T> accumulator)
    //      BinaryOperator<T> functional method:
    //          T apply(T, T);
    // The "identity" is the initial value of the reduction and also
    // what is returned if the stream is empty. This means that there
    // will always be a result and thus Optional is not the return type
    // (on this version of reduce()).
    // The "accumulator" combines the current result with the
    // current value in the stream.
    String name = Stream.of("s", "e", "a", "n")
//                        . filter(s -> s.length()>2)
//                       .reduce("nothing", (s, c) -> s + c);
        .reduce("", (s, c) -> s + c);
    System.out.println(name);// sean

    var myName = Stream.of("H", "I", "E", "P", "M").filter(s -> !s.contains("M"))
        .reduce("", (s, c) -> s + c);
    System.out.println(myName);

    Integer product = Stream.of(2, 3, 4).reduce(1, (a, b) -> a * b);
    System.out.println(product);// 24
  }

  public static void doReduce2() {
    // Optional<T> reduce(BinaryOperator<T> accumulator)
    // When you leave out the identity, an Optional is
    // returned because there may not be any data (all the
    // elements could have been filtered out earlier). There are
    // 3 possible results:
    //      a) empty stream => empty Optional returned
    //      b) one element in stream => that element is returned
    //      c) multiple elements in stream => accumulator is applied
    BinaryOperator<Integer> op = (a, b) -> a + b;
    Stream<Integer> empty = Stream.empty();
    Stream<Integer> oneElement = Stream.of(6);
    Stream<Integer> multipleElements = Stream.of(3, 4, 5);
    empty.reduce(op).ifPresent(System.out::println);            //
    oneElement.reduce(op).ifPresent(System.out::println);       // 6
    multipleElements.reduce(op).ifPresent(System.out::println); // 12
    // Why not just require the identity and remove this method?
    // Sometimes it is nice to know if the stream is empty as opposed
    // to the case where there is a value returned from the accumulator2
    // that happens to match the identity (however unlikely).
    Integer val = Stream.of(1, 1, 1)
        //     .filter(n -> n > 5)      // val is 1 this way
        .reduce(1, (a, b) -> a);// val is 1 this way too
    System.out.println(val);// 1

    var multiplyOperator = (BinaryOperator<Integer>) (a, b) -> a * b;
    Stream.of(1, 2, 3, 4, 5, 6)
        .filter(n -> n % 2 == 0)
        .reduce(multiplyOperator)
        .ifPresent(System.out::println); // 48
  }

  public static void doReduce3() {
    // <U> U reduce (U identity,
    //               BiFunction accumulator,
    //               BinaryOperator combiner)
    // We use this version when we are dealing with different types,
    // allowing us to create intermediate reductions and then combine
    // them at the end. This is useful when working with parallel
    // streams - the streams can be decomposed and reassembled by
    // separate threads. For example, if we wanted to count the length
    // of four 1000-character strings, the first 2 values and the last
    // two values could be calculated independently. The intermediate
    // results (2000) would then be combined into a final value (4000).
    // Example: we want to count the number of characters in each String
    Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
    int length = stream.reduce(0,  // identity
        (n, str) -> n + str.length(), // n is Integer
        Integer::sum); // both are Integers
    System.out.println(length);// 20
  }

  public static void doCollect1() {
    // StringBuilder collect(Supplier<StringBuilder> supplier,
    //               BiConsumer<StringBuilder,String> accumulator
    //               BiConsumer<StringBuilder,StringBuilder> combiner)
    // This version is used when you want complete control over
    // how collecting should work. The accumulator adds an element
    // to the collection e.g. the next String to the StringBuilder.
    // The combiner takes two collections and merges them. It is useful
    // in parallel processing.
    StringBuilder word = Stream.of("ad", "jud", "i", "cate")
        .collect(StringBuilder::new,    // StringBuilder::new
            StringBuilder::append,     // StringBuilder::append
            StringBuilder::append);   // StringBuilder::append
    System.out.println(word);// adjudicate
  }
}
