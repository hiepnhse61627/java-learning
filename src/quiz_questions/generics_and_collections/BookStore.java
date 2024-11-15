package quiz_questions.generics_and_collections;

import java.util.HashMap;
import java.util.Map;

class Book {

  private String isbn;

  public Book(String isbn) {
    this.isbn = isbn;
  }

  public String getIsbn() {
    return isbn;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Book book) {
      return this.isbn.equals(book.getIsbn());
    }

    return false;
  }

  @Override
  public int hashCode() {
    return 100;
  }
}

public class BookStore {

  static Map<Book, Integer> map = new HashMap<>();

  static  {
    Book book = new Book("ABC");
    map.put(book, 10);
  }

  public static int getNumberOfBooks(Book book) {
    return map.get(book);
  }

  public static void main(String[] args) {
    Book book = new Book("ABC");

    System.out.println(getNumberOfBooks(book));
  }
}
