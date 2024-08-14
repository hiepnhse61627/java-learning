package lambda_expressions;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceAPI {

  public static void main(String[] args) {
    var functionalInterfaceAPI = new FunctionalInterfaceAPI();

    System.out.println("==================== Predicate ====================");
    functionalInterfaceAPI.predicate();
    System.out.println("==================== Supplier ====================");
    functionalInterfaceAPI.supplier();
    System.out.println("==================== Consumer ====================");
    functionalInterfaceAPI.consumer();
    System.out.println("==================== Function ====================");
    functionalInterfaceAPI.function();
    System.out.println("==================== Unary/Binary Operator ====================");
    functionalInterfaceAPI.unaryBinaryOperator();
  }

  public void predicate() {
    var predicateStr = (Predicate<String>) s -> s.contains("City");
    System.out.println(predicateStr.test("Vatican City"));

    var checkLength = (BiPredicate<String, Integer>) (string, length) -> string.length() == length;
    System.out.println(checkLength.test("Vatican City", 8));
  }

  public void supplier() {
    var supplierStringBuilder = (Supplier<StringBuilder>) StringBuilder::new;
    System.out.println("Supplier StringBuilder: " + supplierStringBuilder.get().append("SK"));

    var supplierTime = (Supplier<LocalTime>) LocalTime::now;
    System.out.println("Supplier LocalTime: " + supplierTime.get());

    var supplierRandom = (Supplier<Double>) Math::random;
    System.out.println("Supplier Double: " + supplierRandom.get());
  }

  public void consumer() {
    var consumerString = (Consumer<String>) System.out::println;
    consumerString.accept("To be or not to be, that is the question");

    var names = List.of("Hiep", "My");
    names.forEach(consumerString);

    var mapCapitalCities = new HashMap<String, String>();
    var biConsumer = (BiConsumer<String, String>) mapCapitalCities::put;
    biConsumer.accept("Dublin", "Ireland");
    biConsumer.accept("Washington DC", "USA");
    System.out.println(mapCapitalCities);

    var mapPrint = (BiConsumer<String, String>) (key, value)
        -> System.out.println(key + " is the capital of " + value);
    mapCapitalCities.forEach(mapPrint);
  }

  public void function() {
    var functionStringLength = (Function<String, Integer>) String::length;
    System.out.println("Function String Length: " + functionStringLength.apply("Hiep Nguyen"));

    var biFunctionStringLength
        = (BiFunction<String, String, Integer>) (s1, s2) -> s1.length() + s2.length();
    System.out.println("BiFunction: " + biFunctionStringLength.apply("Hiep", "Nguyen"));

    var biFunctionConcat = (BiFunction<String, String, String>) String::concat;
    System.out.println("BiFunctionConcat: " + biFunctionConcat.apply("Hiep", "Nguyen"));
  }

  public void unaryBinaryOperator() {
    var unaryOperator = (UnaryOperator<String>) (name) -> "My name is " + name;
    System.out.println("UnaryOperator: " + unaryOperator.apply("Hiep"));

    var binaryOperator = (BinaryOperator<String>) String::concat;
    System.out.println("BinaryOperator: " + binaryOperator.apply("Hiep", "Nguyen"));
  }
}
