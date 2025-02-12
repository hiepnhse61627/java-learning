package ocp1721book.generics;

import java.util.List;

class Base {

  public void processData(DataHolder<String> data) {
    System.out.println(data.getData());
  }

  public Object process(String data) {
    System.out.println(data.length());
    return data;
  }

  public List processList(List data) {
    System.out.println("Base ProcessList" + data.size());
    return null;
  }
}

class SubClass extends Base {
//  public void processData(DataHolder<Integer> data) {}

  @Override
  public String process(String data) {
    System.out.println("SubClass: " + data.length());
    return data;
  }

  @Override
  public List<String> processList(List data) {
    return super.processList(data);
  }
}

public class TestClassOverriding {

  public static void main(String[] args) {
    Base b = new SubClass();
    b.process("A");
  }
}
