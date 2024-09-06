package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target({ElementType.FIELD, ElementType.PARAMETER}) // 1.
//@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR}) // 2.
@Target({ElementType.TYPE_USE}) // 3.
@interface DataItem {

}

@DataItem
class X { // annotation type not applicable to this type of declaration

}

@DataItem
interface Y { // annotation type not applicable to this type of declaration

}

class Z {

  @DataItem
  int a;

  @DataItem
  static int b;

  @DataItem
  Z() {
  }

  void m1(@DataItem int a) {
  }
}

/////////////////////////////////////////////////////////////////////////////////
@Target(ElementType.TYPE_USE)
@interface Wildcard {

}

class X1 {

  @Wildcard
  int x;

  @Wildcard
  static int y;

  void m1(@Wildcard int a) {
    @Wildcard int z = 0;
    var x1 = new @Wildcard X1();

    int n = (@Wildcard int) 23.9;
  }
}
/////////////////////////////////////////////////////////////////////////////////

public class TargetExample {

  public static void main(String[] args) {

  }
}
