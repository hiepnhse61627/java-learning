package io_api.nio2;

import io_api.model.ImportantBook;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomSerialisation {

  public static void main(String[] args) {
    // Serialize an ImportantBook
    try (var out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream("important_book.ser")))) {
      var importantBook = new ImportantBook("Hiep Nguyen", "111-2-333-55555-1", 29);
      System.out.println("BEFORE: " + importantBook);
      out.writeObject(importantBook);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    // Deserialize ImportantBook
    try (var in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream("important_book.ser")))) {
      var importantBook = (ImportantBook) in.readObject();
      System.out.println("AFTER: " + importantBook);
    } catch (IOException | ClassNotFoundException ex) {
      ex.printStackTrace();
    }
  }
}
