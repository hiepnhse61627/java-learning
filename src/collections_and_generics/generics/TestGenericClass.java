package collections_and_generics.generics;

class MyGeneric<T> {

  T instance;

  MyGeneric(T instance) {
    this.instance = instance;
  }

  public T getT() {
    return instance;
  }
}

public class TestGenericClass {

  public static void main(String[] args) {
    // String on LHS maps to T and "SK" on RHS maps to 'instance'
    MyGeneric<String> g = new MyGeneric<String>("SK");
    System.out.println(g.getT());
    // Integer on LHS maps to T and 1 on RHS maps to 'instance'
    MyGeneric<Integer> g2 = new MyGeneric<Integer>(1);
    System.out.println(g2.getT());
  }
}
