package io_api.model;

import java.io.Serializable;

public class Book extends InfoMedium implements Serializable {

  private BookMarker bookMarker = new BookMarker();
  private String theAuthor;

  public Book() { // IS NOT called when de-serialising as this class IS Serializable
    theAuthor = "Unknown";
  }

  public String getTheAuthor() {
    return theAuthor;
  }

  public void setTheAuthor(String theAuthor) {
    this.theAuthor = theAuthor;
  }

  public BookMarker getBookMarker() {
    return bookMarker;
  }

  public void setBookMarker(BookMarker bookMarker) {
    this.bookMarker = bookMarker;
  }

  @Override
  public String toString() {
    return getTheMedium() + "; " + getTheAuthor() + "; " + bookMarker.toString();
  }
}
