package lambda_expressions;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefsAndContext {

  public static void main(String[] args) {
    // No person being passed in => Supplier
    var noPersonLambda = (Supplier<Integer>) () -> Person.howMany();
    var noPersonMethodReference = (Supplier<Integer>) Person::howMany;
    System.out.println(noPersonLambda.get());
    System.out.println(noPersonMethodReference.get());

    // One person to be passed in => Function
    var onePersonLambda = (Function<Person, Integer>) (person) -> person.howMany(person);
    var onePersonMethodReference = (Function<Person, Integer>) Person::howMany;
    System.out.println(onePersonLambda.apply(new Person()));
    System.out.println(onePersonMethodReference.apply(new Person()));

    // Two persons to be passed in => BiFunction
    var twoPersonLambda = (BiFunction<Person, Person, Integer>)
        (person1, person2) -> Person.howMany(person1, person2);
    var twoPersonMethodReference = (BiFunction<Person, Person, Integer>) Person::howMany;
    System.out.println(twoPersonLambda.apply(new Person(), new Person()));
    System.out.println(twoPersonMethodReference.apply(new Person(), new Person()));
  }
}

class Person {

  public static Integer howMany(Person... person) {
    return person.length;
  }
}
