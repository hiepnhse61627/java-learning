package io_api.model;

import java.io.Serializable;

public class BookMarker implements Serializable {

  private transient Image image = new Image();

  private String marker;

  public BookMarker() {
    this.marker = "Unknown";
  }

  public String getMarker() {
    return marker;
  }

  public void setMarker(String marker) {
    this.marker = marker;
  }

  @Override
  public String toString() {
    return "BookMarker{" +
        "marker='" + marker + '\'' +
        '}';
  }
}
