package collections_and_generics.generics;

class Foo {

  private int fooValue;

  public Foo(int fooValue) {
    this.fooValue = fooValue;
  }

  public int getFooValue() {
    return fooValue;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Foo otherFoe) {
      return this.fooValue == otherFoe.fooValue;
    }

    return false;
  }
}

public class Equals {

  public static void main(String[] args) {
    Foo foo1 = new Foo(2);
    Foo foo2 = new Foo(2);
    System.out.println(foo1.equals(foo2)); // true
    System.out.println(foo1.equals("SK")); // false (no ClassCastException)
  }
}
