package quiz_questions.advanced_class_design;

class A {

}

public class OCPJPv821383 {

  public class A {

    public void m() {
    }
  }

  class B extends A {

  }

  public static void main(String[] args) {
    // anonymous classes are always final
    new OCPJPv821383().new A() {
      @Override
      public void m() {
        System.out.println("M");
      }
    };

//    new B(); works if class B is static
  }
}
