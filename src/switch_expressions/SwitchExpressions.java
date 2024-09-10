package switch_expressions;

enum DIRECTION {NORTH, SOUTH, EAST, WEST}

public class SwitchExpressions {

  public static void main(String[] args) {
    var direction = DIRECTION.NORTH;

    // switch statement (fall-through => requires 'break')
    int numLetters = 0;
    switch (direction) {
      case NORTH:
      case SOUTH:
        numLetters = 5;
        break;
      case EAST:
      case WEST:
        numLetters = 4;
        break;
    }

    System.out.println(numLetters);

    // Any expression result in a single value and switch expressions are no different.
    // switch expression came in java 14.
    // - use of the "->" token
    // - no fall-through logic
    // - case labels must cover all values (insert 'default')
    // Labels with ":" such as above require a 'break' (or 'yield') to prevent fall-through.
    // If you use the "->" token then there is no fall-through.
    System.out.println(
        switch (direction) {
          case NORTH, SOUTH -> 5;
          default -> 4;
//          case EAST, WEST : yield 5; // 'yield' came in Java 13
//          default : yield 4;
        }
    );
  }
}
