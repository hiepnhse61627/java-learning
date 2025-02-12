package ocp1721book.interfaces;

interface Readable {
  int SIZE = 10;

  default void doIt() {
    System.out.println("Readable doIt");
  }
}

interface Writable {
  int SIZE = 20;

  default void doIt() {
    System.out.println("Writable doIt");
  }
}

interface ReadWritable extends Readable, Writable {

  int SIZE = 30;

  @Override
  default void doIt() {
    System.out.println("ReadWritable doIt");
  }
}

class Document {
  private String type = "dummy";
  private byte[] data;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
}

class PdfDocument extends Document {
  private String type = "pdf";

  @Override
  public String getType() {
    return this.type;
  }
}

public class TestClass03 {

  public static void main(String[] args) {
    Document doc = new PdfDocument();
    System.out.println(doc.getType());
  }
}
