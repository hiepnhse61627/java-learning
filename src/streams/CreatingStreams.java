package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreams {

  public static void main(String[] args) {
    System.out.println("=".repeat(20) + " fromArray " + "=".repeat(20));
    fromArray();

    System.out.println("=".repeat(20) + " fromCollection " + "=".repeat(20));
    fromCollection();

    System.out.println("=".repeat(20) + " creatingPrimitiveStreams " + "=".repeat(20));
    creatingPrimitiveStreams();

    // finite streams
    // using Stream.of(varargs)
    Stream<String> animals = Stream.of("cat", "dog", "sheep");
    Stream<Integer> numbers = Stream.of(21, 34, 17);

    // converting a Collection to a stream
    List<String> animalList = Arrays.asList("cat", "dog", "sheep");
    // using stream() which is a default method in Collection interface
    Stream<String> fromList = animalList.stream();
    // creating a parallel stream
    Stream<String> fromListParallel = animalList.parallelStream();

    // infinite streams
    Stream<Double> randoms = Stream.generate(Math::random);// Supplier
    Stream<Integer> oddNumbers = Stream.iterate(1,          // seed
        n -> n + 2);  // next number ('n' is 1 first off)

    // Java 9
    Stream<Integer> oddNumbersJava9 = Stream.iterate(1, // seed
        n -> n < 100,  // Predicate to say when done
        n -> n + 2);   // next number
  }

  public static void fromArray() {
    var numbers = new Double[]{1.1, 2.2, 3.3};
    // Arrays.stream() creates a stream from the array 'numbers'.
    // The array is considered the source of the stream and while the
    // data is flowing through the stream, we have an opportunity to
    // operate on the data.
    var stream1 = Arrays.stream(numbers);

    // let's perform an operation on the data
    // note that count() is a "terminal operation" - this means that
    // you cannot perform any more operations on the stream.
    var n = stream1.count();
    System.out.println("Number of elements: " + n);

    // Re-creating the stream using Stream.of()
    //   static <T> Stream<T> of(T... values)
    var stream2 = Stream.of(numbers);
    System.out.println("Number of elements: " + stream2.count());

    var stream3 = Stream.of("Austria", "New Zealand");
    System.out.println("Number of elements: " + stream3.count());
  }

  public static void fromCollection() {
    var listOfAnimals = Arrays.asList("cat", "dog", "sheep");
    // using stream() which is a default method in Collection interface
    var streamAnimals = listOfAnimals.stream();
    System.out.println("Number of elements: " + streamAnimals.count());

    // stream() is a default method in the Collection interface and therefore
    // is inherited by all classes that implement Collection. Map is NOT one
    // of those i.e. Map is not a Collection. To bridge between the two, we
    // use the Map method entrySet() to return a Set view of the Map (Set
    // IS-A Collection).
    var namesToAges = new HashMap<String, Integer>();
    namesToAges.put("Mike", 22);
    namesToAges.put("Mary", 24);
    namesToAges.put("Alice", 31);

    System.out.println("Number of entries: " +
        namesToAges
            .entrySet() // get a Set (i.e. Collection) view of the Map
            .stream()   // stream() is a default method in Collection
            .count());  // 3
  }

  public static void creatingPrimitiveStreams() {
    var integerArray = new int[]{1, 2, 3, 4, 5};
    var doubleArray = new double[]{1.1, 2.2, 3.3};
    var longArray = new long[]{1L, 2L, 3L, 4L, 5L};

    var intStream = Arrays.stream(integerArray);
    var doubleStream = Arrays.stream(doubleArray);
    var longStream = Arrays.stream(longArray);

    System.out.println(intStream.count() + ", " + doubleStream.count() + ", " + longStream.count());

    var integerStream2 = IntStream.of(integerArray);
    var doubleStream2 = DoubleStream.of(doubleArray);
    var longStream2 = LongStream.of(longArray);

    System.out.println(
        integerStream2.count() + ", " + doubleStream2.count() + ", " + longStream2.count());
  }
}
