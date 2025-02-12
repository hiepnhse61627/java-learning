package ocp1721book.exceptions;

class BadValueException extends RuntimeException {

  BadValueException(String message) {
    super(message);
  }

  BadValueException(String message, Throwable cause) {
    super(message, cause);
  }
}

public class TestClass {

  public double compute(double a, double b) throws Exception {
    if (a < 0) {
      throw new Exception();
    }

    return a + b;
  }

  public static void main(String[] args) {
    String[] sa = {"bob", null, "charlie"};
    String concatenated = "";

    try {
      try {
        for (String s : sa) {
          if (s == null) {
            throw new BadValueException("Bad Value");
          } else {
            concatenated = concatenated.concat(s);
          }
        }
      } catch (BadValueException bve) {
        throw new BadValueException("Unacceptable", bve);
      }
    } catch (Exception e) {
      System.out.print("Exception caught: " + e.getMessage() + " ");
    }
    System.out.println(concatenated);
  }
}
