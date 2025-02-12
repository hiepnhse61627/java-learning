package ocp1721book.interfaces;

interface Moveable {
  default void move() {
    System.out.println("Move Dummy implementation");
  }
}

interface Readable2 {
  default void read() {
    System.out.println("Read Dummy implementation");
  }
}

abstract class Price implements Moveable, Readable2 {
//  public void move() {
//    System.out.println("Price is moving");
//  }
}

interface Printable {
  default void print() {
    System.out.println("Pritable implementation");
  }
}

class StockPrice extends Price implements Printable {

  @Override
  public void print() {
    System.out.println("StockPrice implementation");
  }
}

public class TestClass {

  public static void main(String[] args) {
    StockPrice sp = new StockPrice();
    sp.read();
    sp.print();
    sp.move();
  }
}
