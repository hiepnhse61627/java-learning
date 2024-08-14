package streams;

import java.util.Optional;
import java.util.stream.IntStream;

public class Optionals {

  public static void main(String[] args) {
    System.out.println("=".repeat(30) + " doOptionalAverage " + "=".repeat(30));
    doOptionalAverage();

    System.out.println("=".repeat(30) + " doOptionalNull " + "=".repeat(30));
    doOptionalNull();

    System.out.println("=".repeat(30) + " doOptionalPrimitiveAverage " + "=".repeat(30));
    doOptionalPrimitiveAverage();
  }

  public static void doOptionalPrimitiveAverage() {
    var optAvg = IntStream.rangeClosed(1, 10).average();
    // DoubleConsumer - functional interface; functional method is:
    //    void accept(double value)
    optAvg.ifPresent(System.out::println); // 5.5
    System.out.println(optAvg.getAsDouble()); // 5.5
    // DoubleSupplier - functional interface; functional method is:
    //    double getAsDouble()
    System.out.println(optAvg.orElseGet(() -> Double.NaN));
  }

  public static void doOptionalNull() {
    var optSK = howToDealWithNull("SK");
    optSK.ifPresent(System.out::println); // SK
    var optNull = howToDealWithNull(null);
    System.out.println(optNull.orElseGet(() -> "Empty Optional")); // Empty optional
  }

  public static Optional<String> howToDealWithNull(String param) {
    // Optional optReturn = param == null ? Optional.empty() : Optional.of(param);
    return Optional.ofNullable(param); // same as previous line
  }

  public static void doOptionalAverage() {
    var optAvg = calcAverage(50, 60, 70);
    // if you do a get() and the Optional is empty you get:
    //    NoSuchElementException: No value present
    // boolean isPresent() protects us from that.
    if (optAvg.isPresent()) {
      System.out.println(optAvg.get()); // 60.0
    }
    // void ifPresent(Consumer c)
    optAvg.ifPresent(System.out::println); // 60.0
    // T orElse(T t)
    System.out.println(optAvg.orElse(Double.NaN)); // 60.0

    var optAvg2 = calcAverage();
    System.out.println(optAvg2.orElse(Double.NaN)); // NaN
    // T orElseGet(Supplier<T> s)
    System.out.println(optAvg2.orElseGet(Math::random));
  }

  // a long way to calculate average (just for showing Optional)
  public static Optional<Double> calcAverage(int... scores) {
    if (scores.length == 0) {
      return Optional.empty();
    }

    var sum = 0;
    for (var score : scores) {
      sum += score;
    }

    return Optional.of((double) sum / scores.length);
  }
}
