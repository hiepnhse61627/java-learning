package quiz_questions.advanced_class_design;

public class OCPJPv821394 {

  public static void main(String[] args) {
    Outer out = new Outer();
    System.out.println(out.getInner().getOi());
  }
}

class Outer {

  private int oi = 20;

  class Inner {

    int getOi() {
      return oi;
    }
  }

  Inner getInner() {
    return new Inner();
  }
}
