package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE) // annotation discarded by the compiler
@interface Mouse {

}                 // i.e. not in .class file

@Retention(RetentionPolicy.CLASS)
@interface Headphone {

}

@Retention(RetentionPolicy.RUNTIME) // annotation stored in .class file and
@interface Keyboard {

}               // available at runtime (via reflection)

public class RetentionExample {

  @Mouse
  String mouse = "Mouse";

  @Keyboard
  String keyboard = "Keyboard";

  @Headphone
  String headphone = "Headphone";

  public static void main(String[] args) {

  }
}
