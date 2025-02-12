package ocp1721book.interfaces;

interface Task {
  int SIZE = 10;

  default void doIt() {
    System.out.println("Doint Task");
  }

  static void doIt2() {}
}

interface Activity {
  long SIZE = 20;

  void doIt();
}

interface TaskActivity extends Task, Activity {

  @Override
  default void doIt() {
    Task.super.doIt();
  }
}

public class TestClass02 implements TaskActivity {

  public static void main(String[] args) {
    TestClass02 test = new TestClass02();
    test.doIt();

    Task.doIt2();
  }

}
