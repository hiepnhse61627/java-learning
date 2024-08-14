package lambda_expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceTypes {

  public static void main(String[] args) {
    System.out.println("==================== Bound Method Reference ====================");
    boundMethodReferences();
    System.out.println("==================== Unbound Method Reference ==================");
    unboundMethodReferences();
    System.out.println("==================== Static Method Reference ===================");
    staticMethodReferences();
    System.out.println("==================== Constructor Method Reference ==============");
    constructorMethodReferences();
  }

  public static void boundMethodReferences() {
    var name = "Mr. Hiep Nguyen";
    // Supplier<T>
    //  T get()
    var lowerLambda = (Supplier<String>) () -> name.toLowerCase();
    var methodReference = (Supplier<String>) name::toLowerCase;

    // No need to say which instance to call it on - the supplier is bound to name
    System.out.println(lowerLambda.get());
    System.out.println(methodReference.get());

    // Predicate<T>
    //  boolean test(T t)
    // Even though startsWith is overloaded, boolean startsWith(String) and startsWith(String, int),
    // because we are creating a Predicate which has a functional method of test(T t), the startsWith(String)
    // is used. This is where "context" is important.
    var titleLambda = (Predicate<String>) (title) -> name.startsWith(title);
    var titleMethodReference = (Predicate<String>) name::startsWith;

    System.out.println(titleLambda.test("Mr"));
    System.out.println(titleMethodReference.test("Ms"));
  }

  public static void unboundMethodReferences() {
    // Function<T, R>
    //  R apply(T)
    //    String apply(String)
    var upperLambda = (Function<String, String>) s -> s.toUpperCase();
    var upperMethodReference = (Function<String, String>) String::toUpperCase;
    // The function is unbound, so you need to specify which instance to call it on
    System.out.println(upperLambda.apply("hiep"));
    System.out.println(upperMethodReference.apply("hiep"));

    // Function<T, U, R>
    //  R apply(T t, U u)
    //    String apply(String, String)
    var concatLambda = (BiFunction<String, String, String>) (s1, s2) -> s1.concat(s2);
    var concatMethodReference = (BiFunction<String, String, String>) String::concat;
    System.out.println(concatLambda.apply("Hiep", "Nguyen"));

    // 1st parameter is used for executing the instance method
    System.out.println(concatMethodReference.apply("Hiep", "Nguyen"));
  }

  public static void staticMethodReferences() {
    // Static method references are considered UNBOUND also.
    // An example static method is Collections.sort(List)
    // Consumer<T>
    //  void accept(T t)
    //    void accept(List<Integer>)
    // NB: Consumer takes on parameter => sort(List) is used, as opposed to sort(List, Comparator)
    var sortLambda = (Consumer<List<Integer>>) list -> Collections.sort(list);
    var sortMethodReference = (Consumer<List<Integer>>) Collections::sort;

    var listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
    sortLambda.accept(listOfNumbers);
    System.out.println(listOfNumbers);

    listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
    sortMethodReference.accept(listOfNumbers);
    System.out.println(listOfNumbers);
  }

  public static void constructorMethodReferences() {
    // Supplier<T>
    //  T get()
    var stringBuilderLambda = (Supplier<StringBuilder>) () -> new StringBuilder();
    var stringBuilderMethodReference = (Supplier<StringBuilder>) StringBuilder::new;
    System.out.println(stringBuilderLambda.get().append("Lambda version"));
    System.out.println(stringBuilderMethodReference.get().append("Method reference version"));

    // Function<T, R>
    //  R apply(T)
    //    List<String> apply(Integer)
    // ArrayList(int initialCapacity)
    var arrayListLambda = (Function<Integer, List<String>>) x -> new ArrayList<>(x);
    var arrayListMethodReference = (Function<Integer, List<String>>) ArrayList::new;

    var list01 = arrayListLambda.apply(10);
    list01.add("10");
    System.out.println(list01);

    var list02 = arrayListMethodReference.apply(21);
    list02.add("21");
    System.out.println(list02);
  }
}
