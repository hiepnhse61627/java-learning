package lambda_expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Assignment01 {

  public static void main(String[] args) {
    var listOfNumbers = Arrays.asList(20, 17, 15, 14, 1);
    var sortConsumer = (Consumer<List<Integer>>) Collections::sort;

    sortConsumer.accept(listOfNumbers);
    System.out.println(listOfNumbers);
  }
}
