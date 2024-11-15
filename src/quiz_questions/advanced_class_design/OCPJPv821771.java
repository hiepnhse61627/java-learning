package quiz_questions.advanced_class_design;

public class OCPJPv821771 {

  public static void main(String[] args) {
    TestClass testClass = new TestClass();
    testClass.m1();

    System.out.println(((T1) testClass).VALUE);
  }
}

class TestClass implements T1, T2 {

  @Override
  public void m1() {
    System.out.println("M1");
  }
}

interface T1 {

  int VALUE = 1;

  void m1();
}

interface T2 {

  int VALUE = 2;

  void m1();
}
