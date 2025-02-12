package ocp1721book.exceptions;

class Device implements AutoCloseable {

  private int index;

  public Device(int index) {
    this.index = index;
    System.out.println("Device " + index + " opened");
  }

  public String read() throws Exception {
    if (index == 2) {
      throw new Exception("Unabled to read Device " + index);
    }
    System.out.println("Device " + index + " reading");
    return "Device " + index + " data";
  }

  @Override
  public void close() {
    throw new RuntimeException("Unabled to close Device " + index);
  }
}

public class TestClass02 {

  public static void main(String[] args) {
    Device d1 = new Device(1);
    try (d1; Device d2 = new Device(2)) {
      d1.read();
      d2.read();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Exception received: " + e);
    } finally {
      System.out.println("In finally");
    }
  }
}
