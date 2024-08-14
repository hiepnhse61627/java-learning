package lambda_expressions;

import java.util.function.Predicate;

// my own custom functional interface
interface Evaluate<T> {

  boolean isNegative(T t); // similar to Predicate
}

public class TestPredicate {

  public static void main(String[] args) {
    // Evaluate<T> is a functional interface i.e. one abstract method:
    //  boolean isNegative(T t); // similar to java.util.function.Predicate
    var lambda = (Evaluate<Integer>) i -> i < 0;
    System.out.println("Evaluate: " + lambda.isNegative(-1));
    System.out.println("Evaluate: " + lambda.isNegative(+1));

    // Predicate<T> is a functional interface i.e. one abstract method:
    //  boolean test(T t);
    var predicate = (Predicate<Integer>) i -> i < 0;
    System.out.println("Predicate: " + predicate.test(-1));
    System.out.println("Predicate: " + predicate.test(+1));

    var x = 4;
    System.out.println("Is " + x + " even? " + check(4, n -> n % 2 == 0));
    x = 7;
    System.out.println("Is " + x + " even? " + check(7, n -> n % 2 == 0));

    var name = "Mr. Hiep Nguyen";
    System.out.println("Does " + name + " start with Mr.? " + check(name, s -> s.startsWith("Mr")));
    name = "Ms. My";
    System.out.println("Does " + name + " start with Mr.? " + check(name, s -> s.startsWith("Mr")));
  }

  public static <T> boolean check(T t, Predicate<T> lambda) {
    return lambda.test(t);
  }
}
