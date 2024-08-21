package collections_and_generics.generics;

interface Moveable<T> {

  void move(T t);
}

class MoveFeline implements Moveable<Cat> {

  @Override
  public void move(Cat cat) {

  }
}

class MoveCanine implements Moveable<Dog> {

  @Override
  public void move(Dog dog) {

  }
}

class SomeMoveable<U> implements Moveable<U> {

  @Override
  public void move(U u) {

  }
}

public class GenericInterface {

  public static void main(String[] args) {
    new MoveFeline().move(new Cat());
//    new MoveFeline().move(new Dog()); // compiler error
    new MoveCanine().move(new Dog());
//    new MoveCanine().move(new Cat()); // compiler error

    new SomeMoveable<Dog>().move(new Dog());
    new SomeMoveable<Cat>().move(new Cat());
  }
}

class RawMoveable implements Moveable { // old way

  public void move(Object o) {
  }
}
