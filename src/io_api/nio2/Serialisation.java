package io_api.nio2;

import io_api.model.Book;
import io_api.model.BookMarker;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialisation {

  public static void main(String[] args) {
    // Serialise a Book
    // creates file here: /Users/nguyenhoanghiep/IdeaProjects/java-learning/
    try (var out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream("book.ser")))) {
      var book = new Book();
      var bookMarker = new BookMarker();
      bookMarker.setMarker("Marker");

      book.setTheMedium("Print");
      book.setBookMarker(bookMarker);
      book.setTheAuthor("Hiep Nguyen");
      System.out.println("BEFORE: " + book);
      out.writeObject(book);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // Deserialize a Book
    try (var in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream("book.ser")))) {
      var book = (Book) in.readObject();
      System.out.println("AFTER: " + book);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
