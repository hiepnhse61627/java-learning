package streams;

import java.util.stream.Stream;

public class ParallelStreams {

  public static void main(String[] args) {
    System.out.println("=".repeat(30) + " parallelStream " + "=".repeat(30));
    parallelStream();

    System.out.println("=".repeat(30) + " sequentialStream " + "=".repeat(30));
    sequentialStream();

    System.out.println("=".repeat(30) + " parallelAddition " + "=".repeat(30));
    parallelAddition();

    System.out.println("=".repeat(30) + " sequentialAddition " + "=".repeat(30));
    sequentialAddition();
  }

  public static void sequentialAddition() {
    /*
            Sequential stream
            10 20 30 40 50 60
               30 30 40 50 60
                  60 40 50 60
                    100 50 60
                       150 60
                          210
        */
    // Sequential stream
    var sum = Stream.of(10, 20, 30, 40, 50, 60)
        // IntStream has the sum() method so we use
        // the mapToInt() method to map from Stream<Integer>
        // to an IntStream (i.e. a stream of int primitives).
        // IntStream mapToInt(ToIntFunction)
        //    ToIntFunction is a functional interface:
        //       int applyAsInt​(T value)
        .mapToInt(n -> n.intValue())
        //  .mapToInt(Integer::intValue)
        //  .mapToInt(n -> n)
        .sum();
    System.out.println("Sum: " + sum); // 210
  }

  public static void parallelAddition() {
    //    var animalsStream = List.of("sheep", "pigs", "horses")
    //        .parallelStream();
    var animalsStream = Stream.of("sheep", "pigs", "horses")
        .parallel();

    /*
     Parallel stream
     Thread 1        Thread 2
     10 20 30        40 50 60
        30 30           90 60
           60             150
                210
    */
    var sum = Stream.of(10, 20, 30, 40, 50, 60)
        .parallel() // Stream<T> method
        .mapToInt(Integer::intValue)
        .sum();
    System.out.println("Sum: " + sum);
  }

  public static void sequentialStream() {
    Stream.of("a", "b", "c")
        .forEach(System.out::println);
  }

  public static void parallelStream() {
    Stream.of("a", "b", "c")
        .parallel()
        .forEach(System.out::println);
  }
}
