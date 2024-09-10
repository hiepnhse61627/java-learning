package switch_expressions;

sealed abstract class Vehicle permits Car, Boat, Train {

}

final class Car extends Vehicle {

  // custom Car method
  public String onRoad() {
    return "I can move on the road";
  }
}

final class Boat extends Vehicle {

}

final class Train extends Vehicle {

}

public class PatternMatchingSwitchExpressions {

  public static void ifStatements(Vehicle v) {
    // Oracle: "...pattern matching introduces new language enhancements that enable you to
    // conditionally extract data from objects with code that's more concise and robust."
    // Pattern matching for instanceof is present since Java 16.
    if (v instanceof Car c) {
      System.out.println("It's a Car: " + c.onRoad());
    } else if (v instanceof Boat) {
      System.out.println("It's a Boat");
    } else if (v instanceof Train) {
      System.out.println("It's a Train");
    } else {
      throw new IllegalArgumentException("Invalid vehicle type");
    }
  }

  public static void patternMatchingSwitch(Vehicle v) {
    switch (v) {
      case Car c -> {
        System.out.println("It's a Car");
        System.out.println("It's a Car: " + c.onRoad());
      }
      case Boat b -> System.out.println("It's a Boat");
      case Train t -> System.out.println("It's a Train");
      case null, default -> throw new IllegalArgumentException("Invalid vehicle type");
    }
  }

  public static int speed(Vehicle v) {
    return switch (v) {
      case Car c -> 10;
      case Boat b -> 12;
      case Train t -> 20;
    };
  }

  public static void main(String[] args) {
    ifStatements(new Car());
    ifStatements(new Boat());
    patternMatchingSwitch(new Train());
    patternMatchingSwitch(new Car());

    System.out.println(speed(new Car()));
  }
}
