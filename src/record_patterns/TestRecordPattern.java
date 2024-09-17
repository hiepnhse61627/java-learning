package record_patterns;

public class TestRecordPattern {

  public static void main(String[] args) {
    recordPattern();
  }

  public static void recordPattern() {
    var p1 = new Person("Hiep Nguyen", 18);
    var p2 = new Person("Tra My", 18);
    nonNesting(p1); // Hiep Nguyen: 18
    nonNesting(p2); // Tra My: 18

    var player1 = new Player(p1, Ability.STRONG);
    var player2 = new Player(p2, Ability.AVERAGE);
    var doubles = new Doubles(player1, player2);

    nesting(doubles);
  }

  public static void nonNesting(Object obj) {
    // Person(String s, Integer nAge) is a "record pattern" which does 2 things:
    //   1. Tests whether the object is of type Person (as usual)
    //   2. Extracts the records components by invoking the component accessor
    //      methods on our behalf.
    if (obj instanceof Person(String s, Integer age)) {
      System.out.println(s + ": " + age);
    }
  }

  public static void nesting(Doubles doubles) {
    // straightforward nesting
    if (doubles instanceof Doubles(Player player1, Player player2)) {
      System.out.println(player1.person() + ": " + player1.ability());
      System.out.println(player2.person() + ": " + player2.ability());
    }

    // more complex nesting
    if (doubles instanceof Doubles(Player(Person p1, Ability ability), var player2)) {
      System.out.println(p1.name() + ": " + p1.age() + ": " + ability.name());
      System.out.println(player2.person());
    }
  }
}
