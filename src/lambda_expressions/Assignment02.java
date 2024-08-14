package lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Assignment02 {

  public static void main(String[] args) {
    boundMethodReference();
    unboundMethodReference();
    staticMethodReference();
    constructorMethodReference();
  }

  public static void boundMethodReference() {
    var x = 1;
    var multiplyNumber = (Supplier<Integer>) () -> x * 2;

    System.out.println(multiplyNumber.get());
  }

  public static void unboundMethodReference() {
    var isEmpty = (Predicate<String>) String::isEmpty;
    System.out.println(isEmpty.test(""));
    System.out.println(isEmpty.test("Hiep"));
  }

  public static void staticMethodReference() {
    var addAllFunction = (Function<List<Integer>, Boolean>)
        list -> Collections.addAll(list, 1, 2, 3, 4, 5);

    var listOfNumbers = new ArrayList<Integer>();
    addAllFunction.apply(listOfNumbers);

    System.out.println(listOfNumbers);
  }

  public static void constructorMethodReference() {
    var stringBuilderSupplier = (Supplier<StringBuilder>) StringBuilder::new;
    System.out.println(stringBuilderSupplier.get().append("Hiep"));
  }
}
