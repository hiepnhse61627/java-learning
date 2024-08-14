package streams;

import java.util.Arrays;

public class Laziness {

  public static void main(String[] args) {
    var names = Arrays.asList("April", "Ben", "Charlie", "David", "Benildus", "Christian");

    /*
     Output:
     April                   - peek
     filter1 : April         - filter1 removes April
     Ben                     - peek
     filter1 : Ben           - filter1 passes Ben on
     filter2 : Ben           - filter2 removes Ben
     Charlie                 - peek
     filter1 : Charlie       - filter1 passes Charlie on
     filter2 : Charlie       - filter2 passes Charlie on
     Charlie                 - forEach()

     Note: limit(1) means David, Benildus or Christian are not
           processed at all i.e. none of them appear in the output
           via "peek()"
    */
    names.stream()
        .peek(s -> System.out.println("peek: " + s))
        .filter(s -> {
          System.out.println("filter1: " + s);
          return s.startsWith("B") || s.startsWith("C");
        })
        .filter(s -> {
          System.out.println("filter2: " + s);
          return s.length() > 3;
        })
        .limit(1)
        .forEach(s -> System.out.println("forEach: " + s));
  }
}
