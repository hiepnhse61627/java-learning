package io_api.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serial;
import java.io.Serializable;

public class ImportantBook implements Serializable {

  @Serial
  private static final long serialVersionUID = 1234567L;

  private String author;
  private String isbn;
  private int authorAge; // effectively 'transient'

  // The following ObjectStreamFields[] states what fields are to be serialized.
  // Any field left out is essentially 'transient'
  // Thus, 'authorAge' is not serialized as it is not listed.
  private static final ObjectStreamField[] fieldsToSerialise = {
      new ObjectStreamField("author", String.class),
      new ObjectStreamField("isbn", String.class),
  };

  public ImportantBook(String author, String isbn, int authorAge) {
    this.author = author;
    this.isbn = isbn;
    this.authorAge = authorAge;
  }

  @Override
  public String toString() {
    return "ImportantBook{" +
        "author='" + author + '\'' +
        ", isbn='" + isbn + '\'' +
        ", authorAge=" + authorAge +
        '}';
  }

  // custom code
  @Serial
  private void writeObject(ObjectOutputStream out) throws IOException {
    var fields = out.putFields();
    // if we were concerned with security, we could encrypt the data first...
    fields.put("author", author + "-Ser");
    fields.put("isbn", isbn + "-Ser");
    out.writeFields();
  }

  @Serial
  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    var fields = in.readFields();
    // if 'author' has no value, 'null' will be used
    // if we had encrypted the data first, now we could decrypt it...
    author = (String) fields.get("author", null);
    isbn = (String) fields.get("isbn", null);
  }
}
