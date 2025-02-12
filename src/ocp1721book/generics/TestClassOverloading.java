package ocp1721book.generics;

class DataHolder<E> {

  private E data;

  public E getData() {
    return data;
  }

  public void setData(E data) {
    this.data = data;
  }
}

public class TestClassOverloading {

  // won't compile if un-comment second method, same erasure
  public void processData(DataHolder<String> data) {
    System.out.println(data.getData());
  }

//  public void processData(DataHolder<Double> data) {
//    System.out.println(data.getData());
//  }
}
