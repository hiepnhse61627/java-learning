package switch_pattern_matching;

sealed interface Color permits Primary, Rainbow {

}

enum Primary implements Color {RED, GREEN, BLUE}

enum Rainbow implements Color {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET}

public class QualifiedEnumConstants {

  public static void main(String[] args) {
    switchPrimary(Primary.RED);
    switchRainbow(Rainbow.RED);
    switchColor(Primary.GREEN);
  }

  private static void switchColor(Color color) {
    switch (color) { // Note: switching on the interface type, not the enum type
//      case Primary primary when primary == Primary.RED: // verbose guarded pattern
//        System.out.println("Primary::Red");
//        break;
//      case Rainbow rainbow when rainbow == Rainbow.RED: // verbose guarded pattern
//        System.out.println("Rainbow::Red");
//        break;

      // Java 21 specific
      case Primary.RED:
        System.out.println("Primary.Red");
        break;
      case Rainbow.RED:
        System.out.println("Rainbow.Red");
        break;
      default:
        System.out.println("Other color");
        break;
    }
  }

  private static void switchPrimary(Primary primary) {
    switch (primary) { // Note: switching on the enum type, not the interface type
      case RED -> System.out.println("Primary::Red");
      case GREEN -> System.out.println("Primary::Green");
    }
  }

  private static void switchRainbow(Rainbow rainbow) {
    switch (rainbow) { // Note: switching on the enum type, not the interface type
      case RED -> System.out.println("Rainbow::Red");
      case GREEN -> System.out.println("Rainbow::Green");
    }
  }
}
