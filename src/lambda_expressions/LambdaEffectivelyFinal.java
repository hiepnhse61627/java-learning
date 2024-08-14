package lambda_expressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {

  String name = "";

  public static void main(String[] args) {
    var names = new ArrayList<String>();
    names.add("Hiep");

    var x = 12; // final or effectively final
    // x++;
    // Lambdas take a snapshot/picture of local variables;
    // these local variables MUST NOT change. Only setting up lambda here
    var lambda = (Predicate<String>) s -> {
      // x++;
      new LambdaEffectivelyFinal().name = "Kennedy"; // instance/class vars are ok
      System.out.println("x == " + x);
      return s.isEmpty() && x % 2 == 0;
    };

    filterData(names, lambda);
    System.out.println(names);

    new LambdaEffectivelyFinal().name = "Sean"; // instance/class vars are ok

    // If 'x' was allowed to change, then the method and the lambda would
    // have 2 different views of 'x'!
    // x++;
    filterData(names, lambda); // lambda views 'x' as 12
  }

  public static void filterData(List<String> list, Predicate<String> lambda) {
    var i = (Iterator<String>) list.iterator();

    while (i.hasNext()) {
      if (lambda.test(i.next())) { // execution lambda here
        i.remove();
      }
    }
  }
}
