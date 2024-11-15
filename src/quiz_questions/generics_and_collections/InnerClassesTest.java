package quiz_questions.generics_and_collections;

class OuterWorld {
  public InnerWorld i = new InnerWorld();

  void doSomething() {
    System.out.println(i.reason);
  }

  private class InnerWorld {
    private String reason = "none";
  }
}

public class InnerClassesTest {

  public static void main(String[] args) {
    OuterWorld o = new OuterWorld();
    o.doSomething();
  }
}
